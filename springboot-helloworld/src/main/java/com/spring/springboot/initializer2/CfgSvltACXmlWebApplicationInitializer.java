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

    /**
     <servlet>
         <servlet-name>normal-webapp</servlet-name>
         <servlet-class>
            org.springframework.web.servlet.DispatcherServlet
         </servlet-class>
         <init-param>
             <param-name>contextConfigLocation</param-name>
             <param-value>/WEB-INF/spring/appServlet/servlet-context.xml</param-value>
             <!--    上面是MVC上下文：读servlet-context.xml的配置    -->
         </init-param>
         <load-on-startup>1</load-on-startup>
     </servlet>
     <servlet-mapping>
         <servlet-name>normal-webapp</servlet-name>
         <url-pattern>/api/*</url-pattern>
     </servlet-mapping>
     */
}
