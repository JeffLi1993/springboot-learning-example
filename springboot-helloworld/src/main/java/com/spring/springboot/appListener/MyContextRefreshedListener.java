package com.spring.springboot.appListener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author Frankie Yang on 2018/1/4.
 */
public class MyContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("**************[ApplicationListener]Frankie Yang 的 Context refreshed ！！！");
    }
}
