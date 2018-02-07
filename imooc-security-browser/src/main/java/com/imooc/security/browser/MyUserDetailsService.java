package com.imooc.security.browser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 * github: https://github.com/douchunlei
 * email: 870191368@qq.com
 *
 * @Author : peter
 * @Date: 2018-02-04 14:11
 * @Description: 自定义用户详情业务逻辑层
 * @Copyright(©) 2018 by peter.
 */
@Component
public class MyUserDetailsService implements UserDetailsService {
    Logger logger = LoggerFactory.getLogger(getClass());
    //可以在这里注入相应的mapper,然后根据用户名去数据库中查询相应的用户信息
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("登录用户名:"+username);
        //1.根据用户名查询用户信息
        //2.根据查找到的用户信息判断用户是否被冻结
        String password = passwordEncoder.encode("123456");
        logger.info("用户密码:"+password);
        return new User(username,password, true,true,true,true,AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
