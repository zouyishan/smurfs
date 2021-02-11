package com.myblog.blog.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myblog.blog.Service.SayService;
import com.myblog.blog.mapper.SayMapper;
import com.myblog.blog.pojo.Say;
import org.springframework.stereotype.Service;

@Service
public class SayServiceImpl extends ServiceImpl<SayMapper, Say> implements SayService {
}
