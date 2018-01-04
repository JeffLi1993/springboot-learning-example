package com.spring.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    /*@Value("${user.name}")
    private String name1;

    @Value("${user.age}")
    private int age;*/
    @Autowired
    private UserSetting user;

    @RequestMapping("/")
    public String sayHello() {
        return "Hello,World!" + "\n" + user.getName() + "\t" + user.getAge();
    }

    @RequestMapping("/whyang")
    @ResponseBody
    public String sayFrankie(){
        out.println("\n\nHelloWorldController\n\n");
        return "Frankie, Spring Boot run ..";
    }
}
