package com.spring.springboot;

import com.spring.springboot.listener.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.logging.AutoConfigurationReportLoggingInitializer;
import org.springframework.boot.builder.ParentContextCloserApplicationListener;
import org.springframework.boot.context.FileEncodingApplicationListener;
import org.springframework.boot.context.config.AnsiOutputApplicationListener;
import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.config.DelegatingApplicationListener;
import org.springframework.boot.context.embedded.ServerPortInfoApplicationContextInitializer;
import org.springframework.boot.context.event.*;
import org.springframework.boot.liquibase.LiquibaseServiceLocatorApplicationListener;
import org.springframework.boot.logging.ClasspathLoggingApplicationListener;
import org.springframework.boot.logging.LoggingApplicationListener;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.*;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.scheduling.annotation.EnableScheduling;
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
//        SpringApplication.run(Application.class, args);
        SpringApplication app = new SpringApplication(Application.class);

        app.addListeners(
                new MyApplicationStartingListener(),
                new MyApplicationFailListener(),
                new MyApplicationReadyListener(),
                new MyApplicationPreparedListener(),
                new MyEnvReadyListener(),
                new MyContextClosedListener(),
                new MyContextRefreshedListener(),
                new MyContextStartedListener(),
                new MyContextStoppedListener()
        );

        app.run(args);
    }


    public void fwefwef(){

        ServletContextInitializer ewfwef;
        WebApplicationInitializer wefwefwef;


        SpringBootConfiguration wer;
        EnableAutoConfiguration wrwer23;

        EnableScheduling we3r;
        EnableCaching werwer;

        SpringFactoriesLoader wer2323r23r;


        SpringApplicationRunListener wewerl;
        ApplicationListener fwefwef;

        ParentContextCloserApplicationListener ewf;
        FileEncodingApplicationListener fwefwe;
        AnsiOutputApplicationListener fwef;
        ConfigFileApplicationListener fwefewf;
        DelegatingApplicationListener ddddergerd;
        LiquibaseServiceLocatorApplicationListener gwgwegweg;
        ClasspathLoggingApplicationListener fwefwewefwef;
        LoggingApplicationListener fwefweflwefl;



        //  org.springframework.context
        ApplicationContextInitializer wefwefwwwef;
            AutoConfigurationReportLoggingInitializer vnbvg;
            ServerPortInfoApplicationContextInitializer fefwefewf;
        //  javax.servlet
        ServletContainerInitializer svltContIniter;
        //  org.springframework.web
        WebApplicationInitializer webAppIniter;
        //  org.springframework.boot.web.servlet
        ServletContextInitializer svltCntxIniter;



//        SpringApplicationRunListeners springAppRunLsnrs;
        SpringApplicationRunListener springAppRunLsnr;
            EventPublishingRunListener ergergerg;
        ApplicationEvent we135rwer;
            SpringApplicationEvent erger34234;
                ApplicationEnvironmentPreparedEvent ewrwer;
                ApplicationPreparedEvent fwefw221ef;
                ApplicationReadyEvent feefw2ef;
                ApplicationFailedEvent efwefeeeeew;
                ApplicationStartingEvent wefwefwef222333;
                    ApplicationStartedEvent fewiioweirf;
            ApplicationContextEvent erfer324;
                ContextClosedEvent fwefwef234234;
                ContextRefreshedEvent owefionwef;
                ContextStoppedEvent voiwne;
                ContextStartedEvent ovwieobwefe;
        ApplicationEventMulticaster gergerg;
            AbstractApplicationEventMulticaster ewwefwef;
                SimpleApplicationEventMulticaster sdgweg;
        ApplicationListener lsnr;
//            rergerg ergerg;
//                rergerg ergerg;


    }


}

