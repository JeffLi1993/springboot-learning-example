package com.spring.springboot.conditionals.five;

import com.spring.springboot.conditionals.one.JdbcUserDAO;
import com.spring.springboot.conditionals.one.MongoUserDAO;
import com.spring.springboot.conditionals.UserDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig5
{
    /**
     * 然而，使用注解实现 Condition 的方式更为优雅。而不是为 MYSQL 和 MongoDB 创建 Condition 实现。
     * 我们可以创建一个 DatabaseType 注解
     * */

    @DatabaseType("MYSQL")
    public UserDAO jdbcUserDAO(){
        return new JdbcUserDAO();
    }
 
    @Bean
    @DatabaseType("MONGO")
    public UserDAO mongoUserDAO(){
        return new MongoUserDAO();
    }
}