package com.spring.springboot.controller;

import com.spring.springboot.domain.City;
import com.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static java.lang.System.out;

/**
 * Created by xchunzhao on 02/05/2017.
 */
@RestController
public class CityRestController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public City findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {
        out.println("\n\n\t\t[3]cityName 4 whyang Parameter from url:\t" + cityName + "\n\n");

        return cityService.findCityByName(cityName);
    }

    @RequestMapping(value = "/")
    @ResponseBody
    public String defaultPage(){
        return "(springboot-mybatis-annotation CityRestController) Default Page";
    }

    @RequestMapping(value = "/api/city/all", method = RequestMethod.GET)
    public String findAllCity() {
        out.println("\n\n\t\t[3]cityName 4 whyang Parameter from url: All City\t" + "\n\n");

        return cityService.findAllCity().toString();
    }

}
