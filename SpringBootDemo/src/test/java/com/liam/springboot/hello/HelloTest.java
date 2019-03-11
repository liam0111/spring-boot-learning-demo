package com.liam.springboot.hello;

import com.liam.springboot.hello.web.HelloController;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @Author: Liam
 * @Date: 2018/11/29 21:56
 */
@SpringBootTest
public class HelloTest {
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @Test
    public void getHello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/hello?name=Liam").accept(MediaType.APPLICATION_JSON_UTF8)).andExpect(
                MockMvcResultMatchers.content().string(Matchers.containsString("Liam")));
    }
}
