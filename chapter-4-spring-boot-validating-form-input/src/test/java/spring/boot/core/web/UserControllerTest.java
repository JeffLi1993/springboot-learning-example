package spring.boot.core.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import spring.boot.core.ValidatingFormInputApplication;
import spring.boot.core.domain.User;
import spring.boot.core.service.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ValidatingFormInputApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class UserControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getUserList() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(view().name("userList"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    private User createUser() {
        User user = new User();
        user.setName("测试用户");
        user.setAge(100);
        user.setBirthday("1994-01-01");
        return userService.insertByUser(user);
    }

    @Test
    public void createUserForm() throws Exception {

        mockMvc.perform(get("/users/create"))
                .andDo(print())
                .andExpect(view().name("userForm"))
                .andExpect(request().attribute("action", "create"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void postUser() throws Exception {
        User user = createUser();
        assertNotNull(user);

        MultiValueMap parameters = new LinkedMultiValueMap<String, String>();
        Map<String, String> maps = objectMapper.convertValue(user, new TypeReference<Map<String, String>>() {
        });
        parameters.setAll(maps);

        mockMvc.perform(post("/users/create").params(parameters))
                .andDo(print())
                .andExpect(status().is(HttpServletResponse.SC_FOUND))
                .andDo(print())
                .andExpect(view().name("redirect:/users/"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void getUser() throws Exception {

        MvcResult result= mockMvc.perform(get("/users/update/{id}/", 1))
                .andExpect(status().isOk())
                .andExpect(view().name("userForm"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("action"))
                .andExpect(model().attribute("user", hasProperty("id", is(1L))))
                .andExpect(model().attribute("user", hasProperty("name", is("Sergey"))))
                .andExpect(model().attribute("user", hasProperty("age", is(24))))
                .andExpect(model().attribute("user", hasProperty("birthday", is("1994-01-01"))))
                .andReturn();


        MockHttpServletResponse mockResponse=result.getResponse();
        assertThat(mockResponse.getContentType()).isEqualTo("text/html;charset=UTF-8");

        Collection<String> responseHeaders = mockResponse.getHeaderNames();
        assertNotNull(responseHeaders);
        assertEquals(2, responseHeaders.size());
        assertEquals("Check for Content-Type header", "Accept-Language", responseHeaders.iterator().next());
        String responseAsString=mockResponse.getContentAsString();
        assertTrue(responseAsString.contains("用户管理"));
    }

    @Test
    public void putUser() throws Exception {
        User user = createUser();
        assertNotNull(user);

        MultiValueMap parameters = new LinkedMultiValueMap<String, String>();
        Map<String, String> maps = objectMapper.convertValue(user, new TypeReference<Map<String, String>>() {
        });
        parameters.setAll(maps);

        mockMvc.perform(post("/users/update").params(parameters))
                .andDo(print())
                .andExpect(status().is(HttpServletResponse.SC_FOUND))
                .andDo(print())
                .andExpect(view().name("redirect:/users/"))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void deleteUser() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders.delete("/users/delete/{id}", 1L) )
                .andDo(print())
                .andExpect(status().is(HttpServletResponse.SC_FOUND))
                .andExpect(view().name("redirect:/users/"));
    }

    public static byte[] convertObjectToJsonBytes(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }
}