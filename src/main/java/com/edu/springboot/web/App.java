package com.edu.springboot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author zhuanxu
 * //public class App extends SpringBootServletInitializer{
 */
@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
@ServletComponentScan
public class App {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(App.class);
        ConfigurableApplicationContext context =  application.run(args);
//        context.close();
    }
}

