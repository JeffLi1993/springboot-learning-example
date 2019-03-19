package org.spring.springboot.service;

import org.spring.springboot.domain.City;

import java.util.List;

/**
 * 城市业务逻辑接口类
 * <p>
 * Created by bysocket on 07/02/2017.
 */
public interface CityService {
    
    List<City> query(String startRow, String stopRow);
    
    public City query(String row);
    
    void saveOrUpdate();
}
