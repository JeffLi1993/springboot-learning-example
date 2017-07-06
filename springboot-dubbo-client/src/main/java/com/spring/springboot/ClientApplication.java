package com.spring.springboot;

import com.spring.springboot.dubbo.CityDubboConsumerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

/**
 * Spring Boot 应用启动类
 *
 * Created by bysocket on 16/4/26.
 */
// Spring Boot 应用的标识
@SpringBootApplication
@PropertySource("classpath:application.properties")
public class ClientApplication implements EmbeddedServletContainerCustomizer {

    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件

        try {
            ConfigurableApplicationContext run = SpringApplication.run(ClientApplication.class, args);

            CityDubboConsumerService cityService = run.getBean(CityDubboConsumerService.class);
//            CityDubboConsumerService cityService = run.getBean("CityDubboConsumerService");

            cityService.printCity();

        } catch (Exception e){}

    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(8082);
    }

}
