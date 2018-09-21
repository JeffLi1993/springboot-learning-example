package com.spring.springboot.initializer2;

import org.springframework.core.annotation.Order;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

/**
 * @author Frankie Yang on 2018/9/20.
 */
@Order(21)
public class CfgSvltACWebApplicationInitializer2 extends AbstractDispatcherServletInitializer {

    /**
     * TODO Important !
     Note: when we extend AbstractDispatcherServletInitializer (see section 3.4), we register both
     a root web application context and a single dispatcher servlet.

     So, if we want more than one servlet, we need multiple AbstractDispatcherServletInitializer implementations.
     However, we can only define one root context, or the application won’t start.

     Fortunately, the createRootApplicationContext method can return null. Thus, we can have one
     AbstractContextLoaderInitializer and many AbstractDispatcherServletInitializer implementations that
     don’t create a root context. In such a scenario, it is advisable to order the initializers with @Order explicitly.

     Also, note that AbstractDispatcherServletInitializer registers the servlet under a given name (dispatcher)
     and, of course, we cannot have multiple servlets with the same name. So, we need to override getServletName:

     实现 抽象类 AbstractDispatcherServletInitializer 有一点不好，就是 必须实现 两个上下文，ROOT上下文 和 servlet上下文；
     所以，如果我们需要 多个 servlet上下文的话，就麻烦了。

     好在 它的方法 createRootApplicationContext 可以返回 null，这样也好；多个 servlet上下文时，实现
     多个 AbstractDispatcherServletInitializer 并且都不搞 ROOT上下文；然后再 单独搞一个 ROOT上下文。

     还可以 使用 @Order 注解设置 各个"servlet上下文" 的顺序。

     另外，多个"servlet上下文"的 servlet 名字应该各不相同；所以，可以实现一个方法 getServletName，各自设置一个 名字。
     * */

    @Override
    protected WebApplicationContext createServletApplicationContext() {

        AnnotationConfigWebApplicationContext secureWebAppContext
                = new AnnotationConfigWebApplicationContext();
        secureWebAppContext.register(SecureWebAppConfig.class);
        return secureWebAppContext;
    }

    @Override
    protected WebApplicationContext createRootApplicationContext(){
        return null;
    }

    @Override
    protected String[] getServletMappings(){
        return new String[] { "/s/api/*" };
    }

    @Override
    protected String getServletName() {
        return "secure-dispatcher-021";
    }

    /**
     <servlet>
         <servlet-name>secure-webapp</servlet-name>
         <servlet-class>
            org.springframework.web.servlet.DispatcherServlet
         </servlet-class>
         <init-param>
             <param-name>contextConfigLocation</param-name>
             <param-value>com.spring.springboot.initializer2.SecureWebAppConfig</param-value>
         </init-param>
         <load-on-startup>1</load-on-startup>
     </servlet>
     <servlet-mapping>
         <servlet-name>secure-webapp</servlet-name>
         <url-pattern>/s/api/*</url-pattern>
     </servlet-mapping>
     */

}

