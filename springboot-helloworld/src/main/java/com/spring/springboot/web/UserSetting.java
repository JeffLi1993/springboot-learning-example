package com.spring.springboot.web;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Frankie Yang on 2018/1/4.
 */
@Component
//通过该注解价值properties文件内的配置
//通过prefix执行properties配置的前缀
@ConfigurationProperties(prefix = "user")
public class UserSetting {
    private String name;
    private Long age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getAge() {
        return age;
    }
    public void setAge(Long age) {
        this.age = age;
    }
}
