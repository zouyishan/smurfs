package com.myblog.blog.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("comment")
public class Comment {
    private String bid;
    private String content;
    private Date createtime;
    private String name;
    private int id;
}
