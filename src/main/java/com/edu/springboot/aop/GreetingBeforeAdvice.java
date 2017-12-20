package com.edu.springboot.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author zhuanxu
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice{
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("========== begin GreetingBeforeAdvice ==========");
        System.out.println("target:"+target.getClass().getName());
        System.out.println("method:"+method.getName());
        System.out.println("args"+Arrays.toString(args));
        System.out.println("========== end GreetingBeforeAdvice ==========");

    }
}
