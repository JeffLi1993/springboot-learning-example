package com.spring.springboot.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

/**
 * @author Frankie Yang on 2018/1/4.
 */
public class MyContextStartedListener implements ApplicationListener<ContextStartedEvent> {
    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println("**************[ApplicationListener]Frankie Yang 的 Context started ！！！");
    }
}
