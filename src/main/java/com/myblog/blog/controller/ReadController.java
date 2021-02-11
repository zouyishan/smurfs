package com.myblog.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.myblog.blog.Service.BlogService;
import com.myblog.blog.Service.CommentService;
import com.myblog.blog.pojo.Blog;
import com.myblog.blog.pojo.Comment;
import com.myblog.blog.util.MarkdownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ReadController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CommentService commentService;


    @GetMapping("/read/{bid}")
    public String read(@PathVariable("bid") String bid, Model model) {
        Blog blog = blogService.getOne(new QueryWrapper<Blog>().eq("bid", bid));
        blog.setViews(blog.getViews()+1);
        blogService.updateById(blog);
        blog.setContent(MarkdownUtils.markdownToHtmlExtensions(blog.getContent()));
        model.addAttribute("blog", blog);
        List<Comment> list = commentService.list(new QueryWrapper<Comment>().eq("bid", bid).orderByDesc("createtime"));
        model.addAttribute("CommentList", list);
        model.addAttribute("bid", bid);
        return "read";
    }

}
