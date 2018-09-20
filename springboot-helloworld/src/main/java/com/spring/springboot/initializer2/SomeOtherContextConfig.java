package com.spring.springboot.initializer2;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Frankie Yang on 2018/9/20.
 */
@Configuration
@Import(RootApplicationConfig.class)
@ImportResource("classpath:basicConfigForPropertiesTwo.xml")
public class SomeOtherContextConfig {

    /**
     * 大概相当于，一个 xml 里 import 另一个 xml
     <import resource="greeting.xml" />
     * */
}
