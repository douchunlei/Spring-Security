package com.imooc.web.filter;



import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 * github: https://github.com/douchunlei
 * email: 870191368@qq.com
 *
 * @Author : peter
 * @Date: 2018-02-02 13:56
 * @Description: 服务耗时过滤器
 * @Copyright(©) 2018 by peter.
 */
//@Component
public class TimeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("start");
        long start = new Date().getTime();
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("filter 服务耗时:"+(new Date().getTime() - start));
        System.out.println("finish");
    }

    @Override
    public void destroy() {
        System.out.println("filter destroy");
    }
}
