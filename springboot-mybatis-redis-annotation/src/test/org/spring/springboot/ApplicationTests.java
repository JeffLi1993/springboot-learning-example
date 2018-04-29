package org.spring.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.spring.springboot.service.impl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by bysocket on 05/06/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);


    @Autowired
    private CityService cityService;

    @Test
    public void testRedis() {
        City city = getShanghai();
        // 向 redis 中存入数据
        cityService.saveCity(city);

        // 从 redis 中取数据
        City cityInfo = cityService.getCityByName("上海");

        LOGGER.info(cityInfo.toString());

    }

    @Test
    public void testRedisCache() {
        City city = getBeijing();
        // 向 redis 中存入数据
        cityService.saveCity(city);

        // 从 redis 中取数据, 第一次查询
        City cityInfo = cityService.getCityByName("北京");
        LOGGER.info("第一次查询：" + cityInfo.toString());

        // 从 redis 中取数据, 第二次查询
        cityInfo = cityService.getCityByName("北京");
        LOGGER.info("第二次查询：" + cityInfo.toString());

        // 更新 city 的描述信息后查询
        cityService.updateCityDescription("北京", "想不想去北京玩玩呢？");
        cityInfo = cityService.getCityByName("北京");
        LOGGER.info("更新描述后查询：" + cityInfo.toString());

    }



    private City getShanghai(){
        return new City(1L, 10L, "上海", "人称魔都的地方");
    }

    private City getBeijing(){
        return new City(2L, 20L, "北京", "中国帝都");
    }
}
