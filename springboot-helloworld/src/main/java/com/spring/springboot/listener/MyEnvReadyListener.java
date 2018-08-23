package com.spring.springboot.listener;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Frankie Yang on 2018/1/4.
 */

public class MyEnvReadyListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        System.out.println("**************[ApplicationListener]Frankie Yang 的 Environment ready ！！！");
    }
}
