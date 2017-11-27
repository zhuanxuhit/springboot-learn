package com.edu.springboot;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(MyImportSelector.class)
// 被注解的类信息在调用 MyImportSelector 方法时候传入
public @interface EnableMy {
    String value() default "";
}
