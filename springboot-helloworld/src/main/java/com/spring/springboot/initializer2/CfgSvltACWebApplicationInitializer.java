package com.spring.springboot.initializer2;

import com.spring.springboot.initializer2.SecureWebAppConfig;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author Frankie Yang on 2018/9/19.
 */
@Order(26)
public class CfgSvltACWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected WebApplicationContext createServletApplicationContext() {

        AnnotationConfigWebApplicationContext secureWebAppContext
                = new AnnotationConfigWebApplicationContext();
        secureWebAppContext.register(NormalWebAppConfig.class);
        return secureWebAppContext;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/api/*" };
    }

    @Override
    protected Class[] getRootConfigClasses(){
        return new Class[]{};
    }

    @Override
    protected Class[] getServletConfigClasses(){
        return new Class[]{};
    }

    @Override
    protected String getServletName() {
        return "normal-dispatcher-026";
    }

    /**
     <servlet>
         <servlet-name>normal-webapp</servlet-name>
         <servlet-class>
            org.springframework.web.servlet.DispatcherServlet
         </servlet-class>
         <init-param>
             <param-name>contextConfigLocation</param-name>
             <param-value>com.spring.springboot.initializer2.NormalWebAppConfig</param-value>
         </init-param>
         <load-on-startup>1</load-on-startup>
     </servlet>
     <servlet-mapping>
         <servlet-name>normal-webapp</servlet-name>
         <url-pattern>/api/*</url-pattern>
     </servlet-mapping>
     */
}
