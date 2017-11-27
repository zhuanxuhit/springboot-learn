package com.edu.springboot;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.Arrays;

// bean 钩子函数，此时没有任何注解需要在 EchoImportBeanDefinitionRegistrar 中引入
public class EchoBeanPostProcessor implements BeanPostProcessor {

    private String[] packages;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        for (String pac : packages) {
            if (bean.getClass().getName().startsWith(pac)) {
                System.out.println("Echo Bean: " + beanName);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public String[] getPackages() {
        return packages;
    }

    public void setPackages(String[] packages) {
        this.packages = packages;
    }
}
