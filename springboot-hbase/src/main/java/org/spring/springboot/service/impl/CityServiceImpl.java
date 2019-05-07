package org.spring.springboot.service.impl;

import com.spring4all.spring.boot.starter.hbase.api.HbaseTemplate;
import org.apache.hadoop.hbase.client.Mutation;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.spring.springboot.dao.CityRowMapper;
import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 城市业务逻辑实现类
 * <p>
 * Created by bysocket on 07/02/2017.
 */
@Service
public class CityServiceImpl implements CityService {
    
    @Autowired private HbaseTemplate hbaseTemplate;
    
    public List<City> query(String startRow, String stopRow) {
        Scan scan = new Scan(Bytes.toBytes(startRow), Bytes.toBytes(stopRow));
        scan.setCaching(5000);
        List<City> dtos = this.hbaseTemplate.find("people_table", scan, new CityRowMapper());
        return dtos;
    }
    
    public City query(String row) {
        City dto = this.hbaseTemplate.get("people_table", row, new CityRowMapper());
        return dto;
    }
    
    public void saveOrUpdate() {
        List<Mutation> saveOrUpdates = new ArrayList<Mutation>();
        Put            put           = new Put(Bytes.toBytes("135xxxxxx"));
        put.addColumn(Bytes.toBytes("people"), Bytes.toBytes("name"), Bytes.toBytes("test"));
        saveOrUpdates.add(put);
        
        this.hbaseTemplate.saveOrUpdates("people_table", saveOrUpdates);
    }
}
