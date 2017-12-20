package com.edu.springboot.aop;

/**
 * @author zhuanxu
 */
public class GreetingImpl implements Greeting{
    @Override
    public void sayHello(String name) {
        before();
        System.out.println("Hello " + name);
        after();
//        try {
//        throw new RuntimeException("error");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
    private void before(){
        System.out.println("GreetingImpl before");
    }
    private void after(){
        System.out.println("GreetingImpl after");
    }


    public void sayGoodMorning() {
        System.out.println("sayGoodMorning");
    }
}
