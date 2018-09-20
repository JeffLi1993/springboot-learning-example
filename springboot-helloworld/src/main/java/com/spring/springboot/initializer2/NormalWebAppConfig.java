package com.spring.springboot.initializer2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Frankie Yang on 2018/9/20.
 */
//Normal context
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.spring.springboot.initializer2"})
public class NormalWebAppConfig /*implements WebMvcConfigurer*/ extends WebMvcConfigurerAdapter {
    //...
}