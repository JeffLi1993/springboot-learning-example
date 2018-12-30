package com.spring.springboot.initializer2;

import org.springframework.beans.factory.access.BeanFactoryLocator;
import org.springframework.beans.factory.access.BeanFactoryReference;
import org.springframework.context.ApplicationContext;
import org.springframework.context.access.ContextSingletonBeanFactoryLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Frankie Yang on 2018/10/23.
 */

//@Configuration
public class CustomROOTSVLTDefaultDispatcherServlet {

    /***
     * 这个做法，有没有效果呢？
     * 看情况，似乎必须 实现 接口WebApplicationInitializer 才可以
     */
    @Bean
    public DispatcherServlet dispatcherServlet()
    {
        DispatcherServlet servlet = new DispatcherServlet();

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.setDisplayName("Self Administration Nx");

        // Registers the application configuration with the root context
        rootContext.setConfigLocation("com.xyz.mnp.config");
        BeanFactoryLocator locator = ContextSingletonBeanFactoryLocator.getInstance("classpath:beanRefContext.xml");
        BeanFactoryReference parentContextRef = locator.useBeanFactory("sharedContext");
        ApplicationContext parentContext = (ApplicationContext) parentContextRef.getFactory();

        rootContext.setParent(parentContext);
        rootContext.register(WebMvcConfigurer.class);

        servlet.setApplicationContext(rootContext);
        return servlet;
    }

}

