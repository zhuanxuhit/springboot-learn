package com.edu.springboot.event;

import org.springframework.context.ApplicationListener;

public class MyApplicationListener2 implements ApplicationListener<MyApplicationEvent>{
    @Override
    public void onApplicationEvent(MyApplicationEvent event) {
        System.out.println("========MyApplicationListener2 收到事件" + event.getClass());
    }
}
