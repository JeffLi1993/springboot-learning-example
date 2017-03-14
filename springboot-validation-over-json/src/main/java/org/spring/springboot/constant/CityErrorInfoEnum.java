package org.spring.springboot.constant;

import org.spring.springboot.result.ErrorInfoInterface;

/**
 * 业务错误码 案例
 *
 * Created by bysocket on 14/03/2017.
 */
public enum CityErrorInfoEnum implements ErrorInfoInterface {
    PARAMS_NO_COMPLETE("000001","params no complete"),
    CITY_EXIT("000002","city exit");

    private String code;

    private String message;

    CityErrorInfoEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode(){
        return this.code;
    }

    public String getMessage(){
        return this.message;
    }
}
