package com.imooc.web.config;

import com.imooc.web.filter.TimeFilter;
import com.imooc.web.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 * github: https://github.com/douchunlei
 * email: 870191368@qq.com
 *
 * @Author : peter
 * @Date: 2018-02-02 14:04
 * @Description: Web相关配置类
 * @Copyright(©) 2018 by peter.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{

    @Autowired
    private TimeInterceptor timeInterceptor;

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        //配置异步处理支持
//        configurer.registerCallableInterceptors();
//        configurer.registerDeferredResultInterceptors();
//        //超时时间
//        configurer.setDefaultTimeout();
        //设置线程池
//        configurer.setTaskExecutor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(timeInterceptor);
    }

    @Bean
    public FilterRegistrationBean timerFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new TimeFilter());
        List<String> urls = new ArrayList<>();
        urls.add("/*");
        filterRegistrationBean.setUrlPatterns(urls);
        return filterRegistrationBean;
    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 网上有些教程就一行代码 registry.addMapping("/**"); 是有问题的：只支持GET、POST，不支持PUT、DELETE、OPTIONS以及contentType是application/json的POST请求
        // registry.addMapping("/**");

        // 最万能的解决办法如下，亲测支持GET、POST、PUT、DELETE、OPTIONS、application/json
        registry.addMapping("/**")//
                .allowedOrigins("*")// 默认是 *
                .allowedMethods("*")// 默认是 simple methods（即 GET、HEAD、POST 并不包含 PUT、DELETE 和 OPTIONS 等）
                .allowedHeaders("*")// 默认是 *
                .allowCredentials(true)// 默认是 true
                .maxAge(1800);// 默认是 1800 秒
    }
}
