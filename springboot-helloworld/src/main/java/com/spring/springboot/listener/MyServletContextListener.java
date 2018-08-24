package com.spring.springboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Frankie Yang on 2018/8/24.
 */
public class MyServletContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce){
        System.out.println("[MyServletContextListener]frankie contextInitialized");
    }

    public void contextDestroyed(ServletContextEvent sce){
        System.out.println("[MyServletContextListener]frankie contextDestroyed");
    }
}
