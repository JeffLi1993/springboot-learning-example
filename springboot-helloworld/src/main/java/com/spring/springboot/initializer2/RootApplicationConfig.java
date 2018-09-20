package com.spring.springboot.initializer2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Frankie Yang on 2018/9/20.
 */
@Configuration
@ComponentScan(basePackages = {"spring.springboot.initializer2"})
class RootApplicationConfig {

    //  配置类 RootApplicationConfig 用于构造 Root上下文，不是 Servlet上下文，所以不需要与 WebMvcConfigurer 有关系。

}
