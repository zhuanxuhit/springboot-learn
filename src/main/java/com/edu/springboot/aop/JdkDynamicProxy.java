package com.edu.springboot.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhuanxu
 */
public class JdkDynamicProxy implements InvocationHandler{
    private Object target;

    public JdkDynamicProxy(Object target) {
        this.target = target;
    }
    @SuppressWarnings("unchecked")
    public <T> T getProxy() {
        return (T)Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target,args);
        after();
        return result;
    }

    private void before(){
        System.out.println("JdkDynamicProxy before");
    }
    private void after(){
        System.out.println("JdkDynamicProxy after");
    }

    public static void main(String[] args) {
        Greeting greeting = new JdkDynamicProxy(new GreetingImpl()).getProxy();
        greeting.sayHello("JdkDynamicProxy");
    }

}
