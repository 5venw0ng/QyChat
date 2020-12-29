package com.vocust.qywx.demo.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

@Configuration
public class AuthConfig extends WebMvcConfigurerAdapter {

    @Resource
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("xxxx");
        System.out.println(authInterceptor);
        // 拦截所有请求，通过判断是否有 @LoginRequired 注解 决定是否需要登录
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/msg/**")
                .addPathPatterns("/web/**")
                .addPathPatterns("/login/queryAllUsers")
                .addPathPatterns("/login/getAllowUsers")
                .excludePathPatterns("/login/userLogin");
    }

}
