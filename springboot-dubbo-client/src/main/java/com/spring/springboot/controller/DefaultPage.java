package com.spring.springboot.controller;

import com.spring.springboot.dubbo.CityDubboConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by whyang on 2017/07/06.
 */

@RestController
public class DefaultPage {

//    @Autowired
//    CityDubboService cityDubboService;

    @Autowired
    CityDubboConsumerService cityDubboCsmrService;

    @RequestMapping("/whyang")
    public String whyangPage(){
        return cityDubboCsmrService.printCity();
    }

}
