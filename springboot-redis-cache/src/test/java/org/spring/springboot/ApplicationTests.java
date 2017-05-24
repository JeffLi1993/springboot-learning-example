package org.spring.springboot;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityCacheService;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private CityService cityService;

	@Autowired
	private CityCacheService cityCacheService;

	@Test
	public void testRedis() {
		City city = getShanghai();
		// 向redis中存入数据
		cityService.insert(city);

		// 从redis中取数据
		City cityInfo = cityService.getByName("上海");

		System.out.println(JSON.toJSONString(cityInfo));

	}

	@Test
	public void testRedisCache() {
		City city = getBeijing();
		// 向redis中存入数据
		cityCacheService.insert(city);

		// 从redis中取数据, 第一次查询
		City cityInfo = cityCacheService.getCityByName("北京");
		System.out.println(JSON.toJSONString("第一次查询：" + JSON.toJSONString(cityInfo)));

		// 从redis中取数据, 第二次查询
		cityInfo = cityCacheService.getCityByName("北京");
		System.out.println(JSON.toJSONString("第二次查询：" + JSON.toJSONString(cityInfo)));

		// 更新city的描述信息后查询
		cityCacheService.updateCityDescription("北京", "想不想去北京玩玩呢？");
		cityInfo = cityCacheService.getCityByName("北京");
		System.out.println(JSON.toJSONString("更新描述后查询：" + JSON.toJSONString(cityInfo)));

	}



	private City getShanghai(){
		return new City(1L, 10L, "上海", "人称魔都的地方");
	}

	private City getBeijing(){
		return new City(2L, 20L, "北京", "中国帝都");
	}
}
