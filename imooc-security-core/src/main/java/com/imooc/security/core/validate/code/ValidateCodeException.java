package com.imooc.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 * github: https://github.com/douchunlei
 * email: 870191368@qq.com
 *
 * @Author : peter
 * @Date: 2018-02-06 9:39
 * @Description: 校验码异常类
 * @Copyright(©) 2018 by peter.
 */
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
