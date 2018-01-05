package com.spring.springboot.service;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Frankie Yang on 2018/1/5.
 */
@ConfigurationProperties(prefix="hello")
public class HelloProperties {

    private static final String MSG = "world";

    private String msg = MSG ;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
