package com.spring.springboot.conditionals.four;

import com.spring.springboot.conditionals.one.JdbcUserDAO;
import com.spring.springboot.conditionals.one.MongoUserDAO;
import com.spring.springboot.conditionals.UserDAO;
import com.spring.springboot.conditionals.two.MongoDriverNotPresentsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig4
{
    /**
     * 我们只想在属性占位符（properties placeholder）配置文件中设置属性 app.dbType = MONGO，
     * 我们该怎么注册 MongoUserDAO bean
     * */

    @Bean
    @Conditional(MongoDriverNotPresentsCondition.class)
    public UserDAO jdbcUserDAO(){
        return new JdbcUserDAO();
    }
 
    @Bean
    @Conditional(MongoDbTypePropertyCondition.class)
    public UserDAO mongoUserDAO(){
        return new MongoUserDAO();
    }
}