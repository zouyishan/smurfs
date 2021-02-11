package com.myblog.blog.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.myblog.blog.pojo.Admin;
import com.myblog.blog.pojo.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AdminServiceImpl adminService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleServiceImpl roleService;
    @Override
    public UserDetails loadUserByUsername(String name) {
        Admin admin = adminService.getOne(new QueryWrapper<Admin>().eq("username", name));
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        if (admin == null) {
            log.info("登录失败: 用户名 ====》" + name);
            return new User("1", "1", authorities);
        }
        else {
            List<Role> aid = roleService.list(new QueryWrapper<Role>().eq("aid", admin.getId()));

            aid.forEach((str) -> {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + str.getRole()));
            });
            log.info("权限 ======》" + authorities);
            log.info("用户名 ====》" + admin.getUsername());
            User user = new User(admin.getUsername(), passwordEncoder.encode(admin.getPassword()), authorities);
            return user;
        }
    }
}
