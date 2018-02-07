package com.imooc.validator;

import com.imooc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 * github: https://github.com/douchunlei
 * email: 870191368@qq.com
 *
 * @Author : peter
 * @Date: 2018-02-01 10:16
 * @Description: 自定义注解业务逻辑处理类
 * @Copyright(©) 2018 by peter.
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint,Object> {
    //注入Service 实现业务逻辑
    @Autowired
    private HelloService helloService;
    @Override
    public void initialize(MyConstraint myConstraint) {
        System.out.println("=====my validator init====");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {

        System.out.println(value);
        helloService.greeting("peter");
        //返回true 校验通过，返回false 校验不通过
        return false;
    }
}
