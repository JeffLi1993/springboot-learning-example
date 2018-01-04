package com.spring.springboot.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

/**
 * @author Frankie Yang on 2018/1/4.
 */
public class MyContextStoppedListener implements ApplicationListener<ContextStoppedEvent> {
    @Override
    public void onApplicationEvent(ContextStoppedEvent event) {
        System.out.println("Frankie Yang 的 Context stopped ！！！");
    }
}
