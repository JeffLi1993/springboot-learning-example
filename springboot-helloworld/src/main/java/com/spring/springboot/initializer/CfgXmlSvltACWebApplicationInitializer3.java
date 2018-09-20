package com.spring.springboot.initializer;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author Frankie Yang on 2018/9/20.
 */
public class CfgXmlSvltACWebApplicationInitializer3 extends AbstractDispatcherServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        XmlWebApplicationContext normalWebAppContext = new XmlWebApplicationContext();
        normalWebAppContext.setConfigLocation("/WEB-INF/normal-webapp-servlet.xml");
        ServletRegistration.Dynamic normal
                = servletContext.addServlet("normal-webapp",
                new DispatcherServlet(normalWebAppContext));
        normal.setLoadOnStartup(1);
        normal.addMapping("/api/*");
    }

    public WebApplicationContext createRootApplicationContext(){
        return new XmlWebApplicationContext();
    }

    public WebApplicationContext createServletApplicationContext(){
        AnnotationConfigWebApplicationContext secureWebAppContext
                = new AnnotationConfigWebApplicationContext();

        secureWebAppContext.register(SecureWebAppConfig.class);
        return secureWebAppContext;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/s/api/*" };
    }

}

