package org.spring.springboot.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 家乡属性
 *
 * Created by bysocket on 17/04/2017.
 */
@Component
public class HomeProperties1 {

    /**
     * 省份
     */
    @Value("${home.province}")
    private String province;

    /**
     * 城市
     */
    @Value("${home.city}")
    private String city;

    /**
     * 描述
     */
    @Value("${home.desc}")
    private String desc;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "HomeProperties1{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
