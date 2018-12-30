package com.spring.springboot.service2;

import org.springframework.context.annotation.Bean;
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

