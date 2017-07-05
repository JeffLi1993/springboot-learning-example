package com.spring.springboot.dao.cluster;

import com.spring.springboot.domain.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 城市 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
@Mapper
public interface CityDao {

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名
     */
    City findByName(@Param("cityName") String cityName);
}
