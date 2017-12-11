package com.edu.springboot.web.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author zhuanxu
 */
public class MyStartupListner  implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("============= application start====");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("============= application destroyed====");
    }
}
