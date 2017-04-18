package org.spring.springboot.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 用户
 *
 * Created by bysocket on 18/04/2017.
 */
@Component
@ConfigurationProperties(prefix = "user")
public class User {

    /**
     * 用户 ID
     */
    private Long id;

    /**
     * 年龄
     */
    private int age;

    /**
     * 用户名称
     */
    private String desc;

    /**
     * 用户 UUID
     */
    private String uuid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", desc=" + desc +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
