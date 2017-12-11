package com.edu.springboot.web.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author zhuanxu
 */
@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(Exception.class)
    public String globalHandler(Error e) {
        return "global handler error: " + e.getMessage();
    }
}
