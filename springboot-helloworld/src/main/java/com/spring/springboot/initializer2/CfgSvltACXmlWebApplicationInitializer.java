package com.spring.springboot.initializer2;

import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author Frankie Yang on 2018/9/20.
 */
@Order(22)
public class CfgSvltACXmlWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        XmlWebApplicationContext normalWebAppContext = new XmlWebApplicationContext();
        normalWebAppContext.setConfigLocation("/WEB-INF/normal-webapp-servlet.xml");
        ServletRegistration.Dynamic normal
                = servletContext.addServlet("normal-webapp-022",
                new DispatcherServlet(normalWebAppContext));
        normal.setLoadOnStartup(1);
        normal.addMapping("/api/*");
    }

}
