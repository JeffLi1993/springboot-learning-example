package com.spring.springboot.initializer;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author Frankie Yang on 2018/8/23.
 */
@Configuration
public class MyWebApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext sc) /*throws ServletException */{
        System.out.println("\n\n\n\n\n\n\n~~~~~~~~~~~~~~~[WebApplicationInitializer]frankie MyWebApplicationInitializer: Server Info =====" + sc.getServerInfo());
    }
}
