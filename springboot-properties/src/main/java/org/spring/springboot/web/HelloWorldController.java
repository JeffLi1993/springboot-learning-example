package org.spring.springboot.web;

import org.spring.springboot.property.HomeProperties;
import org.spring.springboot.property.UserProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot HelloWorld 案例
 *
 * Created by bysocket on 16/4/26.
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String sayHello() {
        return "(springboot-properties HelloWorldController) Hello,World!";
    }

    @RequestMapping("/home")
    public String homePage(){
        return new HomeProperties().toString();
    }

    @RequestMapping("/user")
    public String userPage(){
        return new UserProperties().toString();
    }

}
