package com.myblog.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("blog")
public class Blog implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String bid;

    private String title; // 博客标题

    private String content; // 博客内容

    private Date createtime; // 创建时间

    private Integer views; // 观看量

    private String categoryname; // 类型名称

    private String url; // 图片地址

    private String description; // 描述

}
