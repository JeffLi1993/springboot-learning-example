package com.spring.springboot.controller;

import com.spring.springboot.service.CityService;
import com.spring.springboot.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by bysocket on 07/02/2017.
 */
@RestController
public class CityRestController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public City findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {
        return cityService.findCityByName(cityName);
    }

    @RequestMapping(value = "/")
    @ResponseBody
    public String defaultPage(){
        return "(springboot-mybatis CityRestController) Default Page";

    }
}
