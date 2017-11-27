package com.edu.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


// 引入多个配置文件
@PropertySources({@PropertySource("classpath:/config/author.properties"),@PropertySource("classpath:/config/tomcat.properties")})
@SpringBootApplication
public class SpringConfig {
    @Bean
    public Runnable createBean1() {
        return () -> {};
    }
    @Bean
    @Profile("dev")
    public Runnable createBean2() {
        System.out.println("===========2===========");
        return () -> {};
    }
    @Bean
    @Profile("test")
    public Runnable createBean3() {
        System.out.println("===========3===========");
        return () -> {};
    }

    @Bean("run_condition")
    // 指定当属性存在的时候才引入bean
    @ConditionalOnProperty(name = "runnable.enable", havingValue = "true",matchIfMissing = false)
    public Runnable createOnCondition() {
        System.out.println("===========4===========");
        return () -> {};
    }

}
