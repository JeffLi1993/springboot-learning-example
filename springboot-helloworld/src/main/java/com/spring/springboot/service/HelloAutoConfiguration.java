package com.spring.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Frankie Yang on 2018/1/5.
 */
@Configuration
@EnableConfigurationProperties(HelloProperties.class)//开启属性注入,通过@autowired注入
@ConditionalOnClass(Hello.class)//判断这个类是否在classpath中存在
//当设置hello=enabled的情况下,如果没有设置则默认为true,即条件符合
@ConditionalOnProperty(prefix="hello", value="enabled", matchIfMissing = true)
public class HelloAutoConfiguration {

    @Autowired
    private HelloProperties helloProperties;

    @Bean//使用java配置方式配置这个类
    @ConditionalOnMissingBean(Hello.class)//容器中如果没有Hello这个类,那么自动配置这个Hello
    public Hello hello() {
        Hello hello = new Hello();
        hello.setMsg(helloProperties.getMsg());
        return hello;
    }

}
