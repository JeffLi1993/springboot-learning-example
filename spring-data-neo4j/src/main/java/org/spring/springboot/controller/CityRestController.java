package org.spring.springboot.controller;

import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 * <p>
 * Created by Andy on 26/03/2018.
 */
@RestController
public class CityRestController {

    @Autowired
    private CityService cityService;

    /**
     * 插入 Neo4j 新城市
     *
     * @param city
     * @return
     */
    @RequestMapping(value = "/api/city", method = RequestMethod.POST)
    public Long createCity(@RequestBody City city) {
        return cityService.saveCity(city);
    }

    /**
     * 插入 Neo4j 新城市
     *
     * @param city
     * @return
     */
    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public City getCity(@RequestParam(value = "name") String name) {
        return cityService.find(name);
    }

    /**
     * 搜索返回分页结果
     *
     * @param name 搜索城市名称
     * @return
     */
    @RequestMapping(value = "/api/city/search", method = RequestMethod.GET)
    public Collection<City> searchCity(@RequestParam(value = "name") String name) {
        return cityService.searchCity(name);
    }
}
