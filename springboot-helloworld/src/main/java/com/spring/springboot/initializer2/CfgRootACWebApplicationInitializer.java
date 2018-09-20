package com.spring.springboot.initializer2;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.AbstractContextLoaderInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author Frankie Yang on 2018/9/19.
 */
public class CfgRootACWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext)
            throws ServletException {

        XmlWebApplicationContext rootContext = new XmlWebApplicationContext();

        rootContext.setConfigLocations("/WEB-INF/rootApplicationContext.xml");

        servletContext.addListener(new ContextLoaderListener(rootContext));

    }

}
