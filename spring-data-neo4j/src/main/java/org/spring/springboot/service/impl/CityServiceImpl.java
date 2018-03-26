package org.spring.springboot.service.impl;

import org.spring.springboot.domain.City;
import org.spring.springboot.repository.CityRepository;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * 城市 Neo4j 业务逻辑实现类
 * <p>
 * Created by Andy on 26/03/2018.
 */
@Service
public class CityServiceImpl implements CityService {
    
    @Autowired
    CityRepository cityRepository; // Neo4j 操作类

    public Long saveCity(City city) {
        City cityResult = cityRepository.save(city);
        return cityResult.getId();
    }

    @Override
    public Collection<City> searchCity(String name) {
        return cityRepository.findByNameLike(name);
    }

	@Override
	public City find(String name) {
        return cityRepository.findByName(name);
	}



}
