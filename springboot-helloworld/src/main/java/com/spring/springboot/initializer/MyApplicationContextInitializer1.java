package com.spring.springboot.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;

@Order(2)
public class MyApplicationContextInitializer1 implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("frankie Initializer: bean count=====" + applicationContext.getBeanDefinitionCount());
    }
}

