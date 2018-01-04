package com.spring.springboot.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

/**
 * @author Frankie Yang on 2018/1/4.
 */
public class MyContextClosedListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("Frankie Yang 的 Context closed 啦！！！");
    }
}
