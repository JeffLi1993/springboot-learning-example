package com.spring.springboot.initializer;

import javax.servlet.Filter;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import javax.servlet.http.HttpServlet;
import java.util.Set;

@HandlesTypes({ HttpServlet.class, Filter.class })
public class CustomServletContainerInitializer implements ServletContainerInitializer {
    public void onStartup(Set<Class<?>> classes, ServletContext servletContext) throws ServletException {
        for(Class c : classes) {
            System.out.println("~~~~~~~~~~~~~~~[ServletContainerInitializer]frankie Initializer:" + c.getName());
        }
    }
}

