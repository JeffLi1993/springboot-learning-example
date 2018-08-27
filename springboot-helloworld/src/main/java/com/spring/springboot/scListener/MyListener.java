package com.spring.springboot.scListener;

import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@Component
public class MyListener implements ServletContextListener {
    private ServletContext context = null;

    // 这个方法在Web应用服务做好接受请求的时候被调用。
    public void contextInitialized(ServletContextEvent event){
        this.context = event.getServletContext();
        //Output a simple message to the server's console
        System.out.println("*******************[MyListener]The Simple Web App. Is Ready");
    }

    public void contextDestroyed(ServletContextEvent event){
        //Output a simple message to the server's console
        System.out.println("*******************[MyListener]The Simple Web App. Has Been Removed");
        this.context = null;
    }

}