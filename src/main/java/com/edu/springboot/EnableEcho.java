package com.edu.springboot;

import org.springframework.context.annotation.Import;

@Import(EchoImportBeanDefinitionRegistrar.class)
// 被 EnableEcho 注解的类信息会在调用 EchoImportBeanDefinitionRegistrar 的时候作为参数传入
public @interface EnableEcho {
    String[] packages();
}
