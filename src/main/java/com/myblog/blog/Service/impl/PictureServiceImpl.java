package com.myblog.blog.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myblog.blog.Service.PictureService;
import com.myblog.blog.mapper.PictureMapper;
import com.myblog.blog.pojo.Picture;
import org.springframework.stereotype.Service;

@Service
public class PictureServiceImpl extends ServiceImpl<PictureMapper, Picture> implements PictureService {
}
