package com.edu.springboot.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Arrays;

/**
 * @author zhuanxu
 */
public class GreetingAroundAdvice implements MethodInterceptor{
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("========== begin GreetingAroundAdvice ==========");
        Object result =  methodInvocation.proceed();
        System.out.println("========== end GreetingAroundAdvice ==========");
        return result;
    }
}
