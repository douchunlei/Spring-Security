package com.imooc.security.core.properties;

/**
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 * github: https://github.com/douchunlei
 * email: 870191368@qq.com
 *
 * @Author : peter
 * @Date: 2018-02-07 15:04
 * @Description: 安全框架常量
 * @Copyright(©) 2018 by peter.
 */
public interface SecurityConstants {

    /**
     * 默认处理验证码的url前缀
     */
    public static final String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/code";

    /**
     * 当请求需要身份认证时，默认跳转的url
     */
    public static final String DEFAULT_UNAUTHENTICATION_URL = "/authentication/require";

    /**
     * 默认的用户名密码登录请求处理url
     */
    public static final String DEFAULT_LOGIN_PROCESSING_URL_FORM = "/authentication/form";

    /**
     * 默认的手机验证码登录请求处理url
     */
    public static final String DEFAULT_LOGIN_PROCESSING_URL_MOBILE = "/authentication/mobile";

    /**
     * 默认登录页
     */
    public static final String DEFAULT_LOGIN_PAGE_URL = "/imooc-signIn.html";

    /**
     * 验证图片验证码时，http请求中默认的携带图片验证码信息的参数名称
     */
    public static final String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "imageCode";

    /**
     * 验证短信验证时，http请求中默认的携带短信验证码的参数名称
     */
    public static final String DEFAULT_PARAMETER_NAME_CODE_SMS = "smsCode";

    /**
     * 发送短信验证码或验证短信验证时，传递手机参数的名称
     */
    public static final String DEFAULT_PARAMETER_NAME_MOBILE = "mobile";
}
