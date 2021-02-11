package com.myblog.blog.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.myblog.blog.Service.PictureService;
import com.myblog.blog.pojo.Picture;
import com.myblog.blog.util.ZouUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class AdminPictureController {
    @Autowired
    private PictureService pictureService;

    @PostMapping("/addPicture")
    public String addPicture(Picture picture) throws IOException {
        picture.setCreatetime(ZouUtil.getTime());
        pictureService.save(picture);
        return "redirect:/picture";
    }

    @GetMapping("/addPicture")
    public String addPicture() {
        return "admin/picture/addPicture";
    }

    @GetMapping("/showPicture")
    public String showPicture(Model model) {
        List<Picture> pictureList = pictureService.list(null);
        model.addAttribute("pictureList", pictureList);
        return "admin/picture/showPicture";
    }

    @GetMapping("/editorPicture")
    public String editorPicture(@RequestParam String name, Model model) {
        Picture picture = pictureService.getOne(new QueryWrapper<Picture>().eq("name", name));
        model.addAttribute("picture", picture);
        log.info("走到了这里" + picture.getName());
        return "admin/picture/editorPicture";
    }

    @PostMapping("/editorPicture")
    public String editorPicture(Picture picture) {
        log.info("图片的名字" + picture.getName());
        pictureService.updateById(picture);
        return "redirect:/picture";
    }

    @PostMapping("/deletePicture")
    public String deletePicture(@RequestParam("name") String name) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        boolean is_ok = pictureService.removeByMap(map);
        if (is_ok) {
            return "redirect:/picture";
        } else {
            log.info("删除图片失败");
            return "redirect:/showPicture";
        }
    }


}
