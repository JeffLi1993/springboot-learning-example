package com.spring.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

/**
 * @author Frankie Yang on 2018/1/3.
 */
public class StartupRunner1 implements CommandLineRunner {
    protected final Logger logger = LoggerFactory.getLogger(StartupRunner1.class);

//    @Order(value = 1)
    @Override
    public void run(String... strings) throws Exception {
        logger.info("hello 1");
        System.out.println("hello 1");
    }
}