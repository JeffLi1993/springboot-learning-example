package com.spring.springboot.initializer1;

import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;

/**
 * @author Frankie Yang on 2018/8/23.
 */
//@Configuration
@Order(6)
public class MyWebApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext sc) /*throws ServletException */{
        System.out.println("\n\n\n\n\n\n\n~~~~~~~~~~~~~~~[WebApplicationInitializer]frankie MyWebApplicationInitializer: Server Info =====" + sc.getServerInfo());
    }
}
