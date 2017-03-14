package org.spring.springboot.web;

import org.spring.springboot.constant.CityErrorInfoEnum;
import org.spring.springboot.result.GlobalErrorInfoException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * Created by bysocket on 16/4/26.
 */
@RestController
public class ErrorJsonController {

    @RequestMapping("/param")
    public String errorJsonParams() throws GlobalErrorInfoException {
        throw new GlobalErrorInfoException(CityErrorInfoEnum.PARAMS_NO_COMPLETE);
    }
}
