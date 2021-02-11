package com.myblog.blog.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myblog.blog.Service.RoleService;
import com.myblog.blog.mapper.RoleMapper;
import com.myblog.blog.pojo.Role;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
}
