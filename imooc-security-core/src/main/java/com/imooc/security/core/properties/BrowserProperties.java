package com.imooc.security.core.properties;

/**
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 * github: https://github.com/douchunlei
 * email: 870191368@qq.com
 *
 * @Author : peter
 * @Date: 2018-02-04 15:19
 * @Description: 浏览器安全配置
 * @Copyright(©) 2018 by peter.
 */
public class BrowserProperties {

    //默认登录页
    private String loginPage = SecurityConstants.DEFAULT_LOGIN_PAGE_URL;

    //登录默认数据返回格式
    private LoginType loginType = LoginType.JSON;

    //记住我的过期时间
    private Integer rememberMeSeconds = 3600;


    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public Integer getRememberMeSeconds() {
        return rememberMeSeconds;
    }

    public void setRememberMeSeconds(Integer rememberMeSeconds) {
        this.rememberMeSeconds = rememberMeSeconds;
    }
}
