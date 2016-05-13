package ca.momentum.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Created by Thiago Lima on 2016-05-11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//@ContextConfiguration("classpath*:spring-mvc-servlet.xml")
@ContextConfiguration({"classpath*:web.xml" })
public class MainControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new MainController()).build();
    }

    @Test
    public void helloWorld() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/home").accept(MediaType.TEXT_PLAIN))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
//                .andExpect(MockMvcResultMatchers.model().attribute("departments", departmentServices.listDepartment()));
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.TEXT_PLAIN))
//                .andExpect(MockMvcResultMatchers.content().string("Hello World!"));
    }
}