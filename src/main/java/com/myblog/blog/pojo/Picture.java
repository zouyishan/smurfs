package com.myblog.blog.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("picture")
public class Picture {
    private String name;
    private int id;
    private String position;
    private String content;
    private String url;
    private Date createtime;
}
