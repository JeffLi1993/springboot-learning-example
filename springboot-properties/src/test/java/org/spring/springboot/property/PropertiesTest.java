package org.spring.springboot.property;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 自定义配置文件测试类
 * <p>
 * Created by bysocket on 17/04/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesTest.class);

    @Autowired
    private HomeProperties1 homeProperties1;

    @Autowired
    private HomeProperties2 homeProperties2;

    @Autowired
    private User user;

    @Test
    public void getHomeProperties1() {
        LOGGER.info(homeProperties1.getProvince());
        Assert.assertEquals("浙江省", homeProperties1.getProvince());

        LOGGER.info(homeProperties1.getCity());
        Assert.assertEquals("温岭松门", homeProperties1.getCity());

        LOGGER.info(homeProperties1.getDesc());
    }

    @Test
    public void getHomeProperties2() {
        LOGGER.info(homeProperties2.getProvince());
        Assert.assertEquals("浙江省", homeProperties2.getProvince());

        LOGGER.info(homeProperties2.getCity());
        Assert.assertEquals("温岭松门", homeProperties2.getCity());

        LOGGER.info(homeProperties2.getDesc());
    }

    @Test
    public void randomTestUser() {
        LOGGER.info(user.toString());
    }

}
