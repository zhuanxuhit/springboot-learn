package com.edu.springboot.aop;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhuanxu
 */
public class CglibDynamicProxy implements MethodInterceptor{

    private CglibDynamicProxy(){
    }
    private static class SingletonHolder{
        private static CglibDynamicProxy instance = new CglibDynamicProxy();
    }

    /**
     * @return CglibDynamicProxy
     */
    public static CglibDynamicProxy getInstance() {
        return SingletonHolder.instance;
    }
    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class<T> cls){
        return (T) Enhancer.create(cls, this);
    }

    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        before();
        Object result =  methodProxy.invokeSuper(target, args);
        after();
        return result;
    }
    private void before(){
        System.out.println("CglibDynamicProxy before");
    }
    private void after(){
        System.out.println("CglibDynamicProxy after");
    }


    public static void main(String[] args) {
        Greeting greeting =  CglibDynamicProxy.getInstance().getProxy(GreetingImpl.class);
        greeting.sayHello("CglibDynamicProxy");
    }

}
