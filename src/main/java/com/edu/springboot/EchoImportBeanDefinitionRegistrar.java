package com.edu.springboot;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Arrays;
import java.util.Map;


// 没有任何注解，但是为什么能注入呢？此时是因为在 @Import 中引入了，看 @EnableEcho
public class EchoImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        Map<String, Object> attributes =  importingClassMetadata.getAnnotationAttributes(EnableEcho.class.getName());
        String[] packages =(String[])attributes.get("packages");
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(EchoBeanPostProcessor.class);
        System.out.println("======" + Arrays.toString(packages));
        beanDefinitionBuilder.addPropertyValue("packages",packages);
        registry.registerBeanDefinition("package",beanDefinitionBuilder.getBeanDefinition());
    }
}
