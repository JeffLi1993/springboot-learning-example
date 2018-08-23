package com.spring.springboot.conditionals.two;

import com.spring.springboot.conditionals.one.JdbcUserDAO;
import com.spring.springboot.conditionals.one.MongoUserDAO;
import com.spring.springboot.conditionals.UserDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig2
{
    /**
     * 假设想要当 MongoDB java 驱动程序类 com.mongodb.Server
     * 在 classpath 上可用时注册 MongoUserDAO bean；
     * 否则，注册 JdbcUserDAO bean
     * */

    @Bean
    @Conditional(MongoDriverNotPresentsCondition.class)
    public UserDAO jdbcUserDAO(){
        return new JdbcUserDAO();
    }
 
    @Bean
    @Conditional(MongoDriverPresentsCondition.class)
    public UserDAO mongoUserDAO(){
        return new MongoUserDAO();
    }
}