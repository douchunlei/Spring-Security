package com.imooc.security.core.validate.code.impl;
import com.imooc.security.core.validate.code.*;
import com.imooc.security.core.validate.code.image.ImageCode;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

/**
 * 校验码处理器的抽象实现
 */
public abstract class AbstractValidateCodeProcessor<C extends ValidateCode> implements ValidateCodeProcessor {

    private Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 操作sesson的工具类
     */
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    /**
     * 收集系统中所有的{@link ValidateCodeGenerator} 接口的实现
     */
    @Autowired
    private Map<String,ValidateCodeGenerator> validateCodeGenerators;
    
    @Override
    public void create(ServletWebRequest request) throws Exception {
        //1.生成校验码 
        C validateCode = generate(request);
        //2.session中存储校验码
        save(request,validateCode);
        //3发送校验码
        send(request,validateCode);
    }

    /**
     * 生成校验码
     * @param request
     * @return
     */
    private C generate(ServletWebRequest request) {
        String type = getValidateCodeType(request).toString().toLowerCase();
        String generatorName = type + ValidateCodeGenerator.class.getSimpleName();
        ValidateCodeGenerator validateCodeGenerator = validateCodeGenerators.get(generatorName);
        if (validateCodeGenerator == null) {
            throw new ValidateCodeException("验证码生成器" + generatorName + "不存在");
        }
        return (C) validateCodeGenerator.generate(request);
    }

    /**
     * 发送校验码，由子类实现
      * @param request
     * @param validateCode
     */
    protected abstract void send(ServletWebRequest request, C validateCode) throws Exception ;

    /**
     * 保存校验码
     * @param request
     * @param validateCode
     */
    private void save(ServletWebRequest request, C validateCode) {
        String sessionKey = getSessionKey(request);
        sessionStrategy.setAttribute(request,sessionKey,validateCode);
    }

    /**
     * 根据url获取校验码的类型
     * @param request
     * @return
     */
    private ValidateCodeType getValidateCodeType(ServletWebRequest request){
        String type = StringUtils.substringBefore(getClass().getSimpleName(), "CodeProcessor");
        return ValidateCodeType.valueOf(type.toUpperCase());
    }


    /**
     * 构建验证码放入session中的key
     * @param request
     * @return
     */
    private String getSessionKey(ServletWebRequest request){

        return SESSION_KEY_PREFIX +  getValidateCodeType(request).toString().toUpperCase();
    }

    @Override
    public void validate(ServletWebRequest servletWebRequest){
        String sessionKey = getSessionKey(servletWebRequest);
        ValidateCodeType validateCodeType = getValidateCodeType(servletWebRequest);
        C seesionCode  = (C) sessionStrategy.getAttribute(servletWebRequest,sessionKey);

        String requestCode = null;
        try {
            logger.info("validateCodeType.getParamNameOnValidate():{}",validateCodeType.getParamNameOnValidate());
            requestCode = ServletRequestUtils.getStringParameter(servletWebRequest.getRequest(),validateCodeType.getParamNameOnValidate());
        } catch (ServletRequestBindingException e) {
            e.printStackTrace();
        }

        if(StringUtils.isBlank(requestCode)){
            throw new ValidateCodeException("验证码不能为空");
        }

        if (seesionCode == null){
            throw new ValidateCodeException("验证码不存在");
        }

        if(seesionCode.isExpried()){
            sessionStrategy.removeAttribute(servletWebRequest,sessionKey);
            throw new ValidateCodeException("验证码已过期");
        }

        if (!StringUtils.equalsIgnoreCase(requestCode,seesionCode.getCode())){
            throw new ValidateCodeException("验证码不匹配");
        }
        sessionStrategy.removeAttribute(servletWebRequest,sessionKey);
    }
}
