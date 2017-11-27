package com.edu.springboot.event;


import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
class EventHandler {

    @EventListener
    void event(MyApplicationEvent event) {
        System.out.println("====== EventHandler 获取到事件");
    }
    @EventListener
    void event(Object event) {
        System.out.println("====== Object EventHandler 获取到事件");
    }
}
