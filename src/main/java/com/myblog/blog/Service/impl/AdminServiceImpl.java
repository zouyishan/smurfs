package com.myblog.blog.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myblog.blog.Service.AdminService;
import com.myblog.blog.mapper.AdminMapper;
import com.myblog.blog.pojo.Admin;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
}
