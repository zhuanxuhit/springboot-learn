package com.edu.springboot.event;

import org.springframework.context.ApplicationEvent;
//import org.springframework.context.ApplicationListener;

public class MyApplicationEvent extends ApplicationEvent{

    /** use serialVersionUID from Spring 1.2 for interoperability */
    private static final long serialVersionUID = 1L;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MyApplicationEvent(Object source) {
        super(source);
//        ApplicationListener
    }
}
