package com.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.config.AnsiOutputApplicationListener;
import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.config.DelegatingApplicationListener;
import org.springframework.boot.liquibase.LiquibaseServiceLocatorApplicationListener;
import org.springframework.boot.logging.ClasspathLoggingApplicationListener;
import org.springframework.boot.logging.LoggingApplicationListener;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContainerInitializer;

/**
 * Spring Boot 应用启动类
 *
 * Created by bysocket on 16/4/26.
 */
// Spring Boot 应用的标识
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(Application.class,args);
        SpringApplication app = new SpringApplication(Application.class);
    }


    public void fwefwef(){

        ServletContextInitializer ewfwef;

        WebApplicationInitializer webIniter;
        ServletContainerInitializer svltContIniter;

        ApplicationContextInitializer appCntxIniter;


        SpringBootServletInitializer bootSvltIniter;


        ApplicationListener appLsnr;
            LoggingApplicationListener lggAppLsnr;
            ClasspathLoggingApplicationListener classPathLggAppLsnr;
            LiquibaseServiceLocatorApplicationListener liquiBaseSvcLocAppLsnr;
            ConfigFileApplicationListener cfgFileAppLsnr;
            AnsiOutputApplicationListener ansiOpAppLsnr;
            DelegatingApplicationListener dlgtAppLsnr;


        SpringApplicationRunListener grwegweg;

    }


}

