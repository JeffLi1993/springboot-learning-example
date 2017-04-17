package org.spring.springboot.property;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 自定义配置文件测试类
 *
 * Created by bysocket on 17/04/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HomePropertiesTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePropertiesTest.class);

    @Autowired
    private HomeProperties homeProperties;

    @Test
    public void getHomeProperties() {
        LOGGER.info(homeProperties.getProvince());
        Assert.assertEquals("浙江省",homeProperties.getProvince());

        LOGGER.info(homeProperties.getCity());
        Assert.assertEquals("温岭松门",homeProperties.getCity());

        LOGGER.info(homeProperties.getDesc());
    }
}
