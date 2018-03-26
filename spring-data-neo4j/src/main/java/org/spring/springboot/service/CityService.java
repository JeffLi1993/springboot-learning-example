
package org.spring.springboot.service;

import org.spring.springboot.domain.City;

import java.util.Collection;

/**
 * 城市 Neo4j 业务接口类
 * <p>
 * Created by Andy on 26/03/2018.
 *
 */
public interface CityService {

    /**
     * 新增  Neo4j 城市信息
     *
     * @param city
     * @return
     */
    Long saveCity(City city);

    /**
     * 查询City
     *
     * @param name
     * @return
     */
    
    City find(String name);

    /**
     * 搜索词搜索，返回城市信息
     * @return
     */
    Collection<City> searchCity(String name);
}