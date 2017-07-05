package com.spring.springboot.service.impl;

import com.spring.springboot.dao.CityDao;
import com.spring.springboot.domain.City;
import com.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.lang.System.out;

/**
 * 城市业务逻辑实现类
 *
 * Created by xchunzhao on 02/05/2017.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    public City findCityByName(String cityName) {
        out.println("\n\n\t\t[4]CityServiceImpl parameter cityName 4 whyang:\t" + cityName +"\n\n");
        return cityDao.findByName(cityName);
    }

    public City[] findAllCity() {
        out.println("\n\n\t\t[4]CityServiceImpl parameter cityName 4 whyang All City:\t" +"\n\n");
        return cityDao.findAllCity();
    }

}
