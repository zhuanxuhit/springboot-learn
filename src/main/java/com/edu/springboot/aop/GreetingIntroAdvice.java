package com.edu.springboot.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * @author zhuanxu
 */
public class GreetingIntroAdvice extends DelegatingIntroductionInterceptor implements Apology {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        return super.invoke(invocation);
    }

    @Override
    public void saySorry(String name) {
        System.out.println("Sorry " + name);
    }

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new GreetingImpl());
        proxyFactory.addAdvice(new GreetingIntroAdvice());
        Apology apology = (Apology)proxyFactory.getProxy();
        apology.saySorry("introduction adivce");
    }
}
