package com.edu.springboot.aop;

/**
 * @author zhuanxu
 */
public class GreetingProxy implements Greeting{
    private Greeting target;

    public GreetingProxy(Greeting target) {
        this.target = target;
    }

    @Override
    public void sayHello(String name) {
        before();
        this.target.sayHello(name);
        after();
    }
    private void before(){
        System.out.println("GreetingProxy before");
    }
    private void after(){
        System.out.println("GreetingProxy after");
    }

    public static void main(String[] args) {
        GreetingProxy proxy = new GreetingProxy(new GreetingImpl());
        proxy.sayHello("proxy");
    }
}
