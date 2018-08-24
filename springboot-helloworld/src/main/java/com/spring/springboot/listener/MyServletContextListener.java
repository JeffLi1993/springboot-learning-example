package com.spring.springboot.listener;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Frankie Yang on 2018/8/24.
 */
@Configuration
public class MyServletContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce){
        System.out.println("~~~~~~~~~~~~~~~[MyServletContextListener]frankie contextInitialized");
    }

    public void contextDestroyed(ServletContextEvent sce){
        System.out.println("~~~~~~~~~~~~~~~[MyServletContextListener]frankie contextDestroyed");
    }
}
