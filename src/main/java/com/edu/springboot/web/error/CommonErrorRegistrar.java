package com.edu.springboot.web.error;

import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.ErrorPageRegistrar;
import org.springframework.boot.web.servlet.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author zhuanxu
 */
//@Component
public class CommonErrorRegistrar implements ErrorPageRegistrar {

    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage error404 = new ErrorPage(HttpStatus.NOT_FOUND,"/404.html");
        ErrorPage error500 = new ErrorPage(HttpStatus.NOT_FOUND,"/500.html");
        ErrorPage args = new ErrorPage(IllegalArgumentException.class,"/args.html");
        registry.addErrorPages(error404,error500,args);
    }
}
