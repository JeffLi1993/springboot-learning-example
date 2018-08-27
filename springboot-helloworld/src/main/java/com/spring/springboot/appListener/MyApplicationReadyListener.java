package com.spring.springboot.appListener;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Frankie Yang on 2018/1/4.
 */
public class MyApplicationReadyListener implements ApplicationListener<ApplicationReadyEvent> {
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println("**************[ApplicationListener]Frankie Yang 的 Application Ready ！！！");
    }
}
