package com.spring.springboot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.System.out;

/**
 * Spring Boot HelloWorld 案例
 *
 * Created by bysocket on 16/4/26.
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String sayHello() {
        return "Hello,World!";
    }

    @RequestMapping("/whyang")
    @ResponseBody
    public String sayFrankie(){
        out.println("\n\nHelloWorldController\n\n");
        return "Frankie, Spring Boot run ..";
    }
}
