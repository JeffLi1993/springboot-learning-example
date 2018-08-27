package com.spring.springboot.initializer;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Configuration
public class MyWebApplicationInitializer2 implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        System.out.println("\n\n\n\n\n\n\n~~~~~~~~~~~~~~~[WebApplicationInitializer]frankie MyWebApplicationInitializer2: Server Info =====" + sc.getServerInfo());
    }
}
