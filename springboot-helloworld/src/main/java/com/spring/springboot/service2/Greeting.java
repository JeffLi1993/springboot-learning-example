package com.spring.springboot.service2;

import org.springframework.stereotype.Component;

@Component
public class Greeting {

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
