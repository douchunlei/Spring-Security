package com.imooc.security.core.validate.code;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 * github: https://github.com/douchunlei
 * email: 870191368@qq.com
 *
 * @Author : peter
 * @Date: 2018-02-07 16:41
 * @Description: ValidateCodeProcessorHolder
 * @Copyright(©) 2018 by peter.
 */
@Component
public class ValidateCodeProcessorHolder {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Map<String,ValidateCodeProcessor> validateCodeProcessors;

    public ValidateCodeProcessor findValidateCodeProcessor(ValidateCodeType type){
        logger.info("type:"+type.getParamNameOnValidate());
        return findValidateCodeProcessor(type.toString().toLowerCase());
    }

    public ValidateCodeProcessor findValidateCodeProcessor(String type){
        String name = type.toLowerCase() + ValidateCodeProcessor.class.getSimpleName();
        ValidateCodeProcessor validateCodeProcessor = validateCodeProcessors.get(name);
        if (validateCodeProcessor == null){
            throw new ValidateCodeException("校验器"+name+"未找到");
        }
        return validateCodeProcessor;
    }
}
