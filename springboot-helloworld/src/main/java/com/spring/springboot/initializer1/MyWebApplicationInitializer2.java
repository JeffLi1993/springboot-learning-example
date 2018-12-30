package com.spring.springboot.initializer1;

import org.springframework.core.Ordered;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

//@Configuration
public class MyWebApplicationInitializer2 implements WebApplicationInitializer, Ordered {
    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        System.out.println("\n\n\n\n\n\n\n~~~~~~~~~~~~~~~[WebApplicationInitializer]frankie MyWebApplicationInitializer2: Server Info =====" + sc.getServerInfo());
    }

    public int getOrder(){
        return 7;
    }
}
