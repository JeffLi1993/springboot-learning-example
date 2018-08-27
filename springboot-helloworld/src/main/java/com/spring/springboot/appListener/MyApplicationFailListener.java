package com.spring.springboot.appListener;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Frankie Yang on 2018/1/4.
 */
public class MyApplicationFailListener implements ApplicationListener<ApplicationFailedEvent> {
    @Override
    public void onApplicationEvent(ApplicationFailedEvent event) {
        System.out.println("**************[ApplicationListener]Frankie Yang 的 Application fail ！！！");
    }
}
