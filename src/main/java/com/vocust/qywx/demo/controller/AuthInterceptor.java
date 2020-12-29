package com.vocust.qywx.demo.controller;

import com.google.gson.Gson;
import com.vocust.qywx.demo.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String token = request.getHeader("token");
        String dbToken = userService.getToken().getPassword();

        Map<String,Object> result = new HashMap<>();

        SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String tokenTime = userService.getToken().getLoginTime();
        Date tokenTimeDate = sdf.parse(tokenTime);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());//当前时间
        calendar.add(Calendar.DATE,-3);

        if (StringUtils.isEmpty(token) || !dbToken.equalsIgnoreCase(token) || calendar.getTime().after(tokenTimeDate)) {
            result.put("key",-1);
            result.put("errmsg","用户未登录，或者登陆过期，请登录后操作！");
            response.getWriter().print(new Gson().toJson(result));
            return false;
        }


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
