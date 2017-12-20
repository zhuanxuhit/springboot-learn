package com.edu.springboot.aop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author zhuanxu
 */
public class GreetingAfterAdvice implements AfterReturningAdvice{

    @Override
    public void afterReturning(Object result, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("========== begin GreetingAfterAdvice ==========");
        System.out.println("target:"+target.getClass().getName());
        System.out.println("method:"+method.getName());
        System.out.println("args"+Arrays.toString(args));
        System.out.println("========== end GreetingAfterAdvice ==========");

    }
}
