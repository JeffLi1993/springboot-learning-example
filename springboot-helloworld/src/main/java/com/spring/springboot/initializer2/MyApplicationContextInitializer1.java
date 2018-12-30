package com.spring.springboot.initializer2;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;

@Order(2)
public class MyApplicationContextInitializer1 implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("~~~~~~~~~~~~~~~[ApplicationContextInitializer]frankie Initializer: bean count=====" + applicationContext.getBeanDefinitionCount());
    }
}

