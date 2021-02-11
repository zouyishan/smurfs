package com.myblog.blog.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("roles")
public class Role {
    private int id;
    private int aid; // admin的id
    private String role;
}
