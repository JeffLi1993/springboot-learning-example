
package org.spring.springboot.service;

import org.spring.springboot.domain.City;

import java.util.List;

public interface CityService {

    /**
     * 新增 ES 城市信息
     *
     * @param city
     * @return
     */
    Long saveCity(City city);

    List<City> findByDescriptionAndScore(String description, Integer score);

    List<City> findByDescriptionOrScore(String description, Integer score);

    List<City> findByDescription(String description);

    List<City> findByDescriptionNot(String description);

    List<City> findByDescriptionLike(String description);
}