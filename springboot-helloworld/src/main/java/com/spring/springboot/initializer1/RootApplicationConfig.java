package com.spring.springboot.initializer1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Frankie Yang on 2018/9/20.
 */
@Configuration
@ComponentScan(basePackages = {"com.spring.springboot.service2"})
class RootApplicationConfig {

    //  配置类 RootApplicationConfig 用于构造 Root上下文，不是 Servlet上下文，所以不需要与 WebMvcConfigurer 有关系。

    //  大概相当于：<context:component-scan base-package="com.baeldung.contexts.services" />

}
