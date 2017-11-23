package com.edu.springboot;

import org.springframework.context.annotation.Import;

@Import(EchoImportBeanDefinitionRegistrar.class)
public @interface EnableEcho {
    String[] packages();
}
