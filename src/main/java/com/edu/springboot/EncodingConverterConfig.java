package com.edu.springboot;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

@SpringBootConfiguration
// 该注解配置会被自动注入因为 @SpringBootApplication 注解会自动扫描
public class EncodingConverterConfig {

    @Bean
    @Conditional(UTF8Condition.class)
    public EncodingConverter createUTF8Converter() {
        return  new UTF8EncodingConverter();
    }
    @Bean
    @Conditional(GBKCondition.class)
    public EncodingConverter createGBKConverter() {
        return  new GBKEncodingConverter();
    }
}
