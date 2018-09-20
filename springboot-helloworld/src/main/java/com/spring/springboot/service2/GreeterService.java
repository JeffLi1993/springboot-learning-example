package com.spring.springboot.service2;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GreeterService {
    @Resource
    private Greeting greeting;
     
    public String greet() {
        return greeting.getMessage();
    }
}

class Greeting {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}