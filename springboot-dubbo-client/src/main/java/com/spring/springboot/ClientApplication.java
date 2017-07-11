package com.spring.springboot;

import com.spring.springboot.dubbo.CityDubboConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * Spring Boot 应用启动类
 *
 * Created by bysocket on 16/4/26.
 */
// Spring Boot 应用的标识
@SpringBootApplication
//@ImportResource("classpath:provider.xml")
@PropertySource("classpath:application.properties")
//@ConfigurationProperties(prefix = "", value = "")
public class ClientApplication extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer {

    private static final Logger logger = LoggerFactory.getLogger(ClientApplication.class);

    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件

        try {

            logger.warn("0");
            ConfigurableApplicationContext run = SpringApplication.run(ClientApplication.class, args);

            logger.warn("1");
            CityDubboConsumerService cityService = run.getBean(CityDubboConsumerService.class);
//            CityDubboConsumerService cityService = run.getBean("CityDubboConsumerService");

            logger.warn("2");
            cityService.printCity();

            logger.warn("3:\t" + cityService.printCity().toString());

        } catch (Exception e){}

    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ClientApplication.class);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(8082);
    }

}
