package com.edu.springboot.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalTime;

/**
 * @author zhuanxu
 */
@WebListener
public class MyContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("app start at " + LocalTime.now().toString());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("app end at " + LocalTime.now().toString());
    }
}
