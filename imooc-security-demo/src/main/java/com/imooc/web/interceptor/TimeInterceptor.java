package com.imooc.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 * github: https://github.com/douchunlei
 * email: 870191368@qq.com
 *
 * @Author : peter
 * @Date: 2018-02-02 14:10
 * @Description: 服务耗时拦截器
 * @Copyright(©) 2018 by peter.
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {

    //之前
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("preHandle");
        httpServletRequest.setAttribute("startTime",new Date().getTime());
        System.out.println(((HandlerMethod)o).getBean().getClass().getName());
        System.out.println(((HandlerMethod)o).getMethod().getName());
        return true;
    }
    //之后
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
        long startTime = (long) httpServletRequest.getAttribute("startTime");
        System.out.println("interceptor 服务耗时："+(new Date().getTime() - startTime));
    }
    //都会被调用
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion");
        long startTime = (long) httpServletRequest.getAttribute("startTime");
        System.out.println("interceptor 服务耗时："+(new Date().getTime() - startTime));
        System.out.println("ex:"+e);
    }
}
