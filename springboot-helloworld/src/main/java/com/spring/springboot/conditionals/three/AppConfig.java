package com.spring.springboot.conditionals.three;

import com.spring.springboot.conditionals.four.MongoDbTypePropertyCondition;
import com.spring.springboot.conditionals.one.JdbcUserDAO;
import com.spring.springboot.conditionals.one.MongoUserDAO;
import com.spring.springboot.conditionals.UserDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig
{
    /**
     * 假设只想在没有其他 UserDAO 类型的 Spring bean 注册时才注册 MongoUserDAO bean，
     * 该怎么办？
     * */

    /**
     * 我们只想在属性占位符（properties placeholder）配置文件中设置属性 app.dbType = MONGO，我们该怎么注册 MongoUserDAO bean
     * */

    @Bean
    @Conditional(MongoDbTypePropertyCondition.class)
    public UserDAO jdbcUserDAO(){
        return new JdbcUserDAO();
    }
 
    @Bean
    @Conditional(UserDAOBeanNotPresentsCondition.class)
    public UserDAO mongoUserDAO(){
        return new MongoUserDAO();
    }
}