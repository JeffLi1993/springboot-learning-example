package com.spring.springboot.appListener;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Frankie Yang on 2018/1/4.
 */
public class MyApplicationStartingListener implements ApplicationListener<ApplicationStartingEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        System.out.println("**************[ApplicationListener]Frankie Yang 的 Application Starting ！！！");
    }
}
