package com.myblog.blog.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.myblog.blog.Service.SayService;
import com.myblog.blog.pojo.Say;
import com.myblog.blog.util.ZouUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class AdminSayController {
    @Autowired
    private SayService sayService;

    @GetMapping("/admin/say")
    public String say() {
        return "admin/say/say";
    }

    @PostMapping("/admin/say")
    public String say(Say say) {
        say.setCreatetime(ZouUtil.getTime());
        sayService.save(say);
        return "redirect:../say";
    }

    @GetMapping("/admin/showSay")
    public String showSay(Model model) {
        List<Say> list = sayService.list(null);
        model.addAttribute("sayList", list);
        return "admin/say/showSay";
    }

    @GetMapping("/admin/editorSay")
    public String editorSay(@RequestParam int id, Model model) {
        Say say = sayService.getOne(new QueryWrapper<Say>().eq("id", id));
        model.addAttribute("say", say);
        return "admin/say/editorSay";
    }

    @PostMapping("/admin/editorSay")
    public String editorSay(Say say) {
        sayService.updateById(say);
        log.info("修改Say成功");
        return "redirect:../say";
    }

    @PostMapping("/admin/deleteSay")
    public String deleteSay(@RequestParam int id) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        boolean b = sayService.removeByMap(map);
        if (b) {
            return "redirect:../say";
        } else {
            log.info("删除说说失败");
            return "redirect:admin/showSay";
        }
    }

}
