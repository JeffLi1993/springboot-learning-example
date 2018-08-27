package com.spring.springboot.scListener;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author Frankie Yang on 2018/8/24.
 */
@Component
public class MyServletContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce){
        System.out.println("~~~~~~~~~~~~~~~[MyServletContextListener]frankie contextInitialized");
    }

    public void contextDestroyed(ServletContextEvent sce){
        System.out.println("~~~~~~~~~~~~~~~[MyServletContextListener]frankie contextDestroyed");
    }
}
