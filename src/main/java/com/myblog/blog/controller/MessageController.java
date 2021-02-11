package com.myblog.blog.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myblog.blog.Service.MessageService;
import com.myblog.blog.mapper.MessageMapper;
import com.myblog.blog.pojo.Message;
import com.myblog.blog.pojo.Say;
import com.myblog.blog.util.ZouUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/message")
    public String message(Model model) {
        Page<Message> pageParam = new Page<>(1, 1000);
        messageService.page(pageParam, new QueryWrapper<Message>().orderByDesc("createtime"));
        List<Message> messageList = pageParam.getRecords();
        model.addAttribute("messageList", messageList);
        return "message";
    }


}
