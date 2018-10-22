package com.spring.springboot.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;

@Order(1)
public class MyApplicationContextInitializer2 implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("~~~~~~~~~~~~~~~[ApplicationContextInitializer]frankie Initializer: app name : " + applicationContext.getDisplayName());
    }
}
