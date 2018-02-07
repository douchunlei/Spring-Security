package com.imooc.security.core.validate.code;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

/**
 * 校验码处理器的抽象实现
 */
public abstract class AbstractValidateCodeProcessor<C> implements ValidateCodeProcessor{

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
        String type = getProcessorType(request);
        ValidateCodeGenerator validateCodeGenerator = validateCodeGenerators.get(type + "CodeGenerator");
        return (C)validateCodeGenerator.generate(request) ;
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
        sessionStrategy.setAttribute(request,SESSION_KEY_PREFIX+getProcessorType(request).toUpperCase(),validateCode);
    }

    /**
     * 根据请求的url获取校验器的类型
     * @param request
     * @return
     */
    private String getProcessorType(ServletWebRequest request){
        return StringUtils.substringAfter(request.getRequest().getRequestURI(),"/code/");
    }
}
