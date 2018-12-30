package com.spring.springboot.initializer1;

import org.springframework.core.annotation.Order;
import org.springframework.web.context.AbstractContextLoaderInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * @author Frankie Yang on 2018/9/19.
 */
@Order(11)
public class CfgRootACWebApplicationInitializer extends AbstractContextLoaderInitializer {
    /**
     * 抽象类 AbstractContextLoaderInitializer 本意是 创建一个 ContextLoaderListener 并且注册到 Servlet Container；
     * 当然，这些默认操作隐藏了，方法 createRootApplicationContext 只需要 AC.register 方法。 
     */  
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        AnnotationConfigWebApplicationContext rootContext
          = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootApplicationConfig.class);
        return rootContext;
    }

    /**
     <listener>
         <listener-class>
             org.springframework.web.context.ContextLoaderListener
         </listener-class>
     </listener>
     <context-param>
         <param-name>contextConfigLocation</param-name>
         <param-value>com.spring.springboot.initializer1.RootApplicationConfig</param-value>
     </context-param>
     */
}

