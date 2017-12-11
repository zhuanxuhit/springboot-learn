package com.edu.springboot.web.servlet;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

/**
 * @author zhuanxu
 */
@SpringBootConfiguration
public class ServletConfiguration {
    @Bean
    public ServletRegistrationBean createBookServlet(){
        return new ServletRegistrationBean(new BookServlet(),"/book.do");
    }
    @Bean
    public FilterRegistrationBean createEchoFilter(){
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setFilter(new EchoFilter());
        filter.setUrlPatterns(Collections.singletonList("/book.do"));
        return filter;
    }

    @Bean
    public ServletListenerRegistrationBean<MyStartupListner> createMyListener(){
        return new ServletListenerRegistrationBean<>(new MyStartupListner());
    }
}
