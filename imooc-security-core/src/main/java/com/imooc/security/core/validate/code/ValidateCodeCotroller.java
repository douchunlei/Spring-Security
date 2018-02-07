package com.imooc.security.core.validate.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 * github: https://github.com/douchunlei
 * email: 870191368@qq.com
 *
 * @Author : peter
 * @Date: 2018-02-04 16:39
 * @Description: 验证码前端控制器
 * @Copyright(©) 2018 by peter.
 */
@RestController
public class ValidateCodeCotroller {

    public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Autowired
    private ValidateCodeGenerator imageCodeGenerator;

    @Autowired
    private ValidateCodeGenerator smsCodeGenerator;

    @Autowired
    private SmsCodeSender smsCodeSender;

    @Autowired
    private Map<String,ValidateCodeProcessor> validateCodeProcessors;

    @GetMapping("/code/{type}")
    public void createCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String type) throws IOException {
        ServletWebRequest servletWebRequest = new ServletWebRequest(request,response);
        try {
            validateCodeProcessors.get(type+"CodeProcessor").create(servletWebRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*@GetMapping("/code/sms")
    public void createSmsCode(HttpServletRequest request,HttpServletResponse response) throws ServletRequestBindingException {
        ServletWebRequest servletWebRequest = new ServletWebRequest(request);
        //生成短信验证码
        ValidateCode smsCode = smsCodeGenerator.generate(servletWebRequest);
        //将短信验证码存放到session中
        sessionStrategy.setAttribute(servletWebRequest,SESSION_KEY,smsCode);
        //发送短信验证码
        String mobile = ServletRequestUtils.getRequiredStringParameter(request,"mobile");
        //通过短信供应商的服务发送短信
        smsCodeSender.send(mobile,smsCode.getCode());
    }*/


    private ValidateCode createImageCode(ServletWebRequest request) {
        return imageCodeGenerator.generate(request);
    }
}
