package com.classes.webconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) { // 允许跨域请求
        registry.addMapping("/**") // 允许的路径
                .allowedOrigins("http://localhost:3000") // 允许的域名
                .allowedHeaders("*") // 允许的请求头
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 允许的方法
                .allowCredentials(true); // 允许携带cookie等验证信息
    }
}