package com.imooc.security.core.properties;

/**
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 * github: https://github.com/douchunlei
 * email: 870191368@qq.com
 *
 * @Author : peter
 * @Date: 2018-02-06 11:00
 * @Description: 验证码默认配置
 * @Copyright(©) 2018 by peter.
 */
public class SmsCodeProperties {

    //验证码字符个数
    private Integer length = 6;

    //超时时间
    private Integer expireIn = 60;

    //验证码拦截接口
    private String url;



    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(Integer expireIn) {
        this.expireIn = expireIn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
