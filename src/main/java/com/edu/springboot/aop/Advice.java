package com.edu.springboot.aop;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author zhuanxu
 */
public class Advice {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new GreetingImpl());
        proxyFactory.addAdvice(new GreetingBeforeAdvice());
        proxyFactory.addAdvice(new GreetingAfterAdvice());
        proxyFactory.addAdvice(new GreetingThrowAdvice());

        Greeting greeting = (Greeting)proxyFactory.getProxy();
        greeting.sayHello("Advice");
    }
}
