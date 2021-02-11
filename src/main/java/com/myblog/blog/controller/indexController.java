package com.myblog.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myblog.blog.Service.BlogService;
import com.myblog.blog.pojo.Blog;
import com.myblog.blog.util.MarkdownUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
public class indexController {

    @Autowired
    private BlogService blogService;

    @GetMapping(value = {"/index", "/"})
    public String indexList(Model model) {
        log.info("这是第二个的index---------------");
        Page<Blog> pageParam = new Page<>(1, 6);
        blogService.page(pageParam,new QueryWrapper<Blog>().orderByDesc("createtime"));
        // 结果

        List<Blog> blogList = pageParam.getRecords();
        int i = 0;
        boolean is_true = false;
        for (Blog blog : blogList) {
            if (blog.getBid().equals("5debb156666b4e26807964b77a2bf067")) {
                is_true = true;
            }
            if (is_true == false) {
                i++;
            }
        }
        if (is_true == true) blogList.remove(i);
        model.addAttribute("blogList",blogList);
        model.addAttribute("pageParam", pageParam);
        return "index";
    }

    @GetMapping("/index/{page}/{limit}")
    public String blogListPage(@PathVariable int page,
                               @PathVariable int limit,
                               Model model) {
        if (page < 1) page = 1;

        Page<Blog> pageParam = new Page<>(page, limit);
        blogService.page(pageParam, new QueryWrapper<Blog>().orderByDesc("createtime"));

        List<Blog> blogList = pageParam.getRecords();
        int i = 0;
        boolean is_true = false;
        for (Blog blog : blogList) {
            if (blog.getBid().equals("5debb156666b4e26807964b77a2bf067")) {
                is_true = true;
            }
            if (is_true == false) {
                i++;
            }
        }
        if (is_true == true) blogList.remove(i);

        model.addAttribute("blogList", blogList);
        model.addAttribute("pageParam", pageParam);
        return "index";
    }

    @GetMapping("/boke")
    public String types(Model model) {
        Blog bid = blogService.getOne(new QueryWrapper<Blog>().eq("bid", "5debb156666b4e26807964b77a2bf067"));
        bid.setContent(MarkdownUtils.markdownToHtmlExtensions(bid.getContent()));
        model.addAttribute("blog", bid);
        return "boke";
    }

    @GetMapping("/friends")
    public String friends() {
        return "friends";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

}
