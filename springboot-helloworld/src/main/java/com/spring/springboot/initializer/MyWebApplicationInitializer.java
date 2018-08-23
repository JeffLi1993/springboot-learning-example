package com.spring.springboot.initializer;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author Frankie Yang on 2018/8/23.
 */
public class MyWebApplicationInitializer implements WebApplicationInitializer {
    public void onStartup(ServletContext sc) throws ServletException {
        System.out.println("~~~~~~~~~~~~~~~[WebApplicationInitializer]frankie Initializer: Server Info =====" + sc.getServerInfo());
    }
}
