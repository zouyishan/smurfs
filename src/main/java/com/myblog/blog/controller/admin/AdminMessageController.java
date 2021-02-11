package com.myblog.blog.controller.admin;

import com.myblog.blog.Service.MessageService;
import com.myblog.blog.pojo.Message;
import com.myblog.blog.util.ZouUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminMessageController {
    @Autowired
    private MessageService messageService;

    // ajax检查名字是否相同
    @RequestMapping("/checkname")
    @ResponseBody
    public String checkname(@RequestParam(value = "name", required = false) String name, HttpServletRequest request) throws UnsupportedEncodingException {
        Map<String, Object> map = new HashMap<>();
        name = request.getParameter("name");
        map.put("name", name);
        Collection<Message> messages = messageService.listByMap(map);
        if (messages.isEmpty()) {
            return "no";
        } else {
            return "ok";
        }
    }

    @GetMapping("/deleteMessage")
    public String deleteMessage(Model model) {
        List<Message> list = messageService.list(null);
        model.addAttribute("messageList", list);
        return "admin/message/deleteMessage";
    }

    @PostMapping("/deleteMessage")
    public String deleteMessage(@RequestParam("name") String name) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", name);
        boolean b = messageService.removeByMap(map);
        if (b == true) {
            return "redirect:/message";
        } else {
            return "redirect:/deleteMessage";
        }
    }

    @PostMapping("/addMessage")
    public String addMessage(Message message) {
        message.setCreatetime(ZouUtil.getTime());
        messageService.save(message);
        return "redirect:/message";
    }
}
