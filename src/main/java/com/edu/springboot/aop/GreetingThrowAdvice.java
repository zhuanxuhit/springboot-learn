package com.edu.springboot.aop;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

public class GreetingThrowAdvice implements ThrowsAdvice{
    public void afterThrowing(Method method, Object[] args, Object target, Exception e) {
        System.out.println("========== in GreetingThrowAdvice ==========");
        System.out.println("target:"+target.getClass().getName());
        System.out.println("method:"+method.getName());
        System.out.println("exception message:"+e.getMessage());
        System.out.println("args"+ Arrays.toString(args));
    }
}
