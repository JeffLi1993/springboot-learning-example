package com.spring.springboot.runListener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author Frankie Yang on 2018/2/9.
 */

public class MySprAppRunLsnr implements SpringApplicationRunListener {

    public MySprAppRunLsnr(SpringApplication application, String[] args) { }


    public void starting(){
        System.out.println("Frankie Yang 的 SpringAppRunListener starting ！！！");

    }

    public void environmentPrepared(ConfigurableEnvironment environment){
        System.out.println("Frankie Yang 的 SpringAppRunListener environmentPrepared ！！！");

    }


    public void contextPrepared(ConfigurableApplicationContext context){
        System.out.println("Frankie Yang 的 SpringAppRunListener contextPrepared ！！！");

    }


    public void contextLoaded(ConfigurableApplicationContext context){
        System.out.println("Frankie Yang 的 SpringAppRunListener contextLoaded ！！！");


    }

    public void finished(ConfigurableApplicationContext context, Throwable exception){
        System.out.println("Frankie Yang 的 SpringAppRunListener finished ！！！");

    }

}
