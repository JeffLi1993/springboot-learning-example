package org.spring.springboot.service;

import org.spring.springboot.domain.City;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CityCacheService {

    // 模拟数据库存储
    private Map<String, City> cityMap = new HashMap<>();

    public void insert(City city){
        // 模拟数据库插入操作
        cityMap.put(city.getCityName(), city);
    }

    @Cacheable(value = "baseCityInfo")
    public City getCityByName(String cityName){
        // 模拟数据库查询并返回
        return cityMap.get(cityName);
    }

    @CachePut(value = "baseCityInfo")
    public void updateCityDescription(String cityName, String description){
        City city = cityMap.get(cityName);
        city.setDescription(description);
        // 模拟更新数据库
        cityMap.put(cityName, city);
    }

}
