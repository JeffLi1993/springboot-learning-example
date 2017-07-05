package com.spring.springboot.service.impl;

import com.spring.springboot.dao.CityDao;
import com.spring.springboot.domain.City;
import com.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.lang.System.out;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Transactional
    public List<City> findAllCity(){
        out.println("\n\nCityRestController ServiceImple\n\n");
        return cityDao.findAllCity();
    }

    @Transactional
    public City findCityById(Long id) {
        return cityDao.findById(id);
    }

    @Override
    @Transactional
    public Long saveCity(City city) {
        return cityDao.saveCity(city);
    }

    @Override
    @Transactional
    public Long updateCity(City city) {
        return cityDao.updateCity(city);
    }

    @Override
    @Transactional
    public Long deleteCity(Long id) {
        return cityDao.deleteCity(id);
    }

}
