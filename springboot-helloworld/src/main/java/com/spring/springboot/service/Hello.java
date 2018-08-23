package com.spring.springboot.service;

/**
 * @author Frankie Yang on 2018/1/5.
 */
public class Hello {

    private String msg;

    public String sayHello() {
        return "hello " + msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
