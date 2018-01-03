package com.spring.springboot.events;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.web.context.support.RequestHandledEvent;

/**
 * @author Frankie Yang on 2018/1/3.
 */
public class GoodEvents {


    //  org.springframework.web.context.support
    RequestHandledEvent event1;
    //  org.springframework.boot.context.event
    ApplicationStartedEvent event2;
    //  org.springframework.boot.context.event
    ApplicationEnvironmentPreparedEvent event3;
    //  org.springframework.boot.context.event
    ApplicationPreparedEvent event5;
    //  org.springframework.boot.context.event
    ApplicationFailedEvent event6;

    ContextStartedEvent event7;



}
