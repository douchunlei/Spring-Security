package com.imooc.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.FIELD}) //指定自定义注解可以标注在方法和属性上面
@Retention(RetentionPolicy.RUNTIME) //运行时注解
@Constraint(validatedBy = MyConstraintValidator.class) //指定当前注解可以使用哪个类进行具体的业务逻辑处理
public @interface MyConstraint {

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
