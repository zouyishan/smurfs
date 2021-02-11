package com.myblog.blog.controller.admin;

import com.myblog.blog.Service.CommentService;
import com.myblog.blog.pojo.Comment;
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

@Controller
@Slf4j
public class AdminCommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/addComment")
    public String comment(Comment comment) {
        comment.setCreatetime(ZouUtil.getTime());
        commentService.save(comment);
        return "redirect:/read/" + comment.getBid();
    }


    @GetMapping("/deleteComment")
    public String deleteComment(Model model) {
        List<Comment> list = commentService.list(null);
        model.addAttribute("CommentList", list);
        return "admin/comment/deleteComment";
    }

    @PostMapping("/deleteComment")
    public String deleteComment(@RequestParam("id") int id) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        boolean b = commentService.removeByMap(map);
        if (b == true) {
            return "redirect:/index";
        } else {
            log.info("删除评论失败");
            return "redirect:/deleteComment";
        }
    }
}
