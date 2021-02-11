package com.myblog.blog.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.myblog.blog.Service.BlogService;
import com.myblog.blog.pojo.Blog;
import com.myblog.blog.util.ZouUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class AdminBlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/admin")
    public String admin() {
        return "admin/admin";
    }

    @GetMapping("/write")
    public String write() {
        return "admin/blog/write";
    }

    @PostMapping("/write")
    public synchronized String write(Blog blog) {
        blog.setBid(ZouUtil.getUuid());
        blog.setViews(0);
        blog.setCreatetime(ZouUtil.getTime());
        blogService.save(blog);
        return "redirect:/index";
    }

    @GetMapping("/editorBlog")
    public String editorBlog(@RequestParam String bid, Model model) {
        log.info("文章bid ========》 "  + bid);
        Blog blog = blogService.getOne(new QueryWrapper<Blog>().eq("bid", bid));
        model.addAttribute("blog", blog);
        log.info("修改文章 ========》 "  + blog.getTitle());
        return "admin/blog/editorBlog";
    }

    @PostMapping("/editorBlog")
    public String editorBlog(Blog blog) {
        blogService.updateById(blog);
        log.info("修改成功 =========》" + blog.getTitle());
        return "redirect:/read/" + blog.getBid();
    }

    @PostMapping("/deleteBlog")
    public String deleteBlog(@RequestParam("bid") String bid) {
        Map<String, Object> map = new HashMap<>();
        map.put("bid", bid);
        boolean b = blogService.removeByMap(map);
        if (b == true) {
            return "redirect:/index";
        } else {
            log.info("删除文章失败");
            return "redirect:/read/" + bid;
        }
    }

}
