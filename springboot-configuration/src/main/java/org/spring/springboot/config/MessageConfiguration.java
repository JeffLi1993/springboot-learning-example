package org.spring.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by bysocket on 08/09/2017.
 */
@Configuration
public class MessageConfiguration {

    @Bean
    public String message() {
        return "message configuration";
    }
}
