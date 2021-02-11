package com.myblog.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myblog.blog.Service.SayService;
import com.myblog.blog.pojo.Say;
import com.myblog.blog.util.ZouUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
public class SayController {
    @Autowired
    private SayService sayService;
    @GetMapping("/say")
    public String Say(Model model) {
        Page<Say> pageParam = new Page<>(1, 1000);
        sayService.page(pageParam, new QueryWrapper<Say>().orderByDesc("createtime"));
        List<Say> sayList = pageParam.getRecords();
        model.addAttribute("sayList", sayList);
        return "talk";
    }

}
