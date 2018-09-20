package com.spring.springboot.initializer;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//Normal context
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.spring.springboot.initializer" })
public class NormalWebAppConfig /*implements WebMvcConfigurer*/ extends WebMvcConfigurerAdapter {
    //...
}