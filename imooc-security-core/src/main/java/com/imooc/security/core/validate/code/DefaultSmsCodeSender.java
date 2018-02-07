package com.imooc.security.core.validate.code;

import org.springframework.stereotype.Component;

/**
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 * github: https://github.com/douchunlei
 * email: 870191368@qq.com
 *
 * @Author : peter
 * @Date: 2018-02-06 18:14
 * @Description: 默认的短信验证码发送器
 * @Copyright(©) 2018 by peter.
 */
public class DefaultSmsCodeSender implements SmsCodeSender {

    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机号"+mobile+"发送短信验证码"+code);
    }
}
