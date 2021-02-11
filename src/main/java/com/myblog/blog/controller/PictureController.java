package com.myblog.blog.controller;

import com.myblog.blog.Service.PictureService;
import com.myblog.blog.pojo.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @GetMapping("/picture")
    public String f1(Model model) {
        List<Picture> list = pictureService.list(null);
        model.addAttribute("pictureList", list);
        return "picture";
    }
}
