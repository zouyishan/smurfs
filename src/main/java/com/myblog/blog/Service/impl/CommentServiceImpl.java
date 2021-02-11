package com.myblog.blog.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myblog.blog.Service.CommentService;
import com.myblog.blog.mapper.CommentMapper;
import com.myblog.blog.pojo.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
}
