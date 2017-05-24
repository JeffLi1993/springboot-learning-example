package org.spring.springboot.service;

import com.alibaba.fastjson.JSON;
import org.spring.springboot.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    private final StringRedisTemplate redisTemplate;

    @Autowired
    public CityService(StringRedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    // 向Redis中插入一条记录
    public City insert(City city){
        // 将CITY对象转化为JSON格式的字符串
        String value = JSON.toJSONString(city);
        // 将JSON格式的CITY信息存入Redis中
        redisTemplate.opsForValue().append(city.getCityName(), value);
        return city;
    }

    // 根据cityName从Redis中取值
    public City getByName(String cityName){
        String value = redisTemplate.opsForValue().get(cityName);
        return JSON.parseObject(value, City.class);
    }

}
