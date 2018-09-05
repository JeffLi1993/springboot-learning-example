package com.spring.springboot.initializer;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;

/**
 * @author Frankie Yang on 2018/8/23.
 */
public class MyServletContainerInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> scls, ServletContext sc) throws ServletException {
        System.out.println("~~~~~~~~~~~~~~~[ServletContainerInitializer]frankie Initializer: Server Info =====" + sc.getServerInfo() + "\t" + sc.getServletContextName());
    }
}
