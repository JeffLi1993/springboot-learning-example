package com.spring.springboot.initializer2;

import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.AbstractContextLoaderInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author Frankie Yang on 2018/9/19.
 */
@Order(13)
public class CfgRootACXmlWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext)
            throws ServletException {

        XmlWebApplicationContext rootContext = new XmlWebApplicationContext();

        rootContext.setConfigLocations("/WEB-INF/rootApplicationContext.xml");

        servletContext.addListener(new ContextLoaderListener(rootContext));

    }

    /**
     <listener>
         <listener-class>
            org.springframework.web.context.ContextLoaderListener
         </listener-class>
     </listener>
     */

}
