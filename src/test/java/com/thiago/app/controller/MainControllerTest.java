package com.thiago.app.controller;

import com.thiago.BaseControllerTestConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Created by Thiago Lima on 2016-05-11.
 */
public class MainControllerTest extends BaseControllerTestConfig {

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new MainController())
                .setViewResolvers(internalResourceViewResolver)
                .build();
    }

    @Test
    public void whenGoHomeThenOk() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/home").accept(MediaType.TEXT_PLAIN))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("indexPage"));
    }
}