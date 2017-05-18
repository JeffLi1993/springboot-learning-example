package org.spring.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Spring Boot HelloWorldController 测试 - {@link HelloWorldController}
 * <p>
 * Created by bysocket on 16/4/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void helloWorldControllerSayHelloTest() throws Exception {

        MvcResult result = mockMvc.perform(get("/")).andExpect(status().isOk()).andReturn();

        assertEquals("Hello,World!", result.getResponse().getContentAsString());
    }


    @Test
    public void testSayHello() {
        assertEquals("Hello,World!", new HelloWorldController().sayHello());
    }
}
