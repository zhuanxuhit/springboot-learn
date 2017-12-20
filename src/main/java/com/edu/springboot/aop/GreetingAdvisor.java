package com.edu.springboot.aop;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

public class GreetingAdvisor {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new GreetingImpl());
        new NameMatchMethodPointcut();
        NameMatchMethodPointcutAdvisor advisor =  new NameMatchMethodPointcutAdvisor();
        advisor.addMethodName("sayGoodMorning");
        advisor.setAdvice(new GreetingAroundAdvice());
        proxyFactory.addAdvisor(advisor);
        GreetingImpl greeting =  (GreetingImpl)proxyFactory.getProxy();
        greeting.sayGoodMorning();
        greeting.sayHello("GreetingAdvisor");
    }
}
