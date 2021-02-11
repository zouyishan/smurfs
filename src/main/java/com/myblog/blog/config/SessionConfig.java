package com.myblog.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

// Redis实现Session共享
// 配置即可，因为SpringSecurity已经自动实现将session存在Redis中
@Configuration
@EnableRedisHttpSession
public class SessionConfig {
}
