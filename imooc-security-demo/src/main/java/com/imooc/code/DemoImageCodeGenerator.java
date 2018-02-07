package com.imooc.code;

import com.imooc.security.core.validate.code.ImageCode;
import com.imooc.security.core.validate.code.ValidateCode;
import com.imooc.security.core.validate.code.ValidateCodeGenerator;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 * github: https://github.com/douchunlei
 * email: 870191368@qq.com
 *
 * @Author : peter
 * @Date: 2018-02-06 14:46
 * @Description: Demo图形验证码生成器
 * @Copyright(©) 2018 by peter.
 */
//@Component("validateCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {

    @Override
    public ValidateCode generate(ServletWebRequest request) {
        System.out.println("更高级的图形验证码生成器");
        return null;
    }
}
