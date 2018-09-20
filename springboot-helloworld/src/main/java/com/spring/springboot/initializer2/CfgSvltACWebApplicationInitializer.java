package com.spring.springboot.initializer2;

import com.spring.springboot.initializer2.SecureWebAppConfig;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author Frankie Yang on 2018/9/19.
 */
public class CfgSvltACWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected WebApplicationContext createServletApplicationContext() {

        AnnotationConfigWebApplicationContext secureWebAppContext
                = new AnnotationConfigWebApplicationContext();
        secureWebAppContext.register(SecureWebAppConfig.class);
        return secureWebAppContext;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/s/api/*" };
    }

    @Override
    protected Class[] getRootConfigClasses(){
        return new Class[]{};
    }

    @Override
    protected Class[] getServletConfigClasses(){
        return new Class[]{};
    }

}
