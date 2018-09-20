package com.spring.springboot.initializer;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//"Secure" context
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.baeldung.contexts.secure" })
public class SecureWebAppConfig /*implements WebMvcConfigurer*/ extends WebMvcConfigurerAdapter {
    //...
}