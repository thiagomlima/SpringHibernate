package ca.momentum.controller;

import ca.momentum.BaseTestControllerConfig;
import ca.momentum.model.entity.Department;
import ca.momentum.model.services.impl.DepartmentServices;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Created by Thiago Lima on 2016-05-11.
 */
public class MainControllerTest extends BaseTestControllerConfig {

    private MockMvc mockMvc;

    @Mock
    DepartmentServices departmentServices;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new MainController(departmentServices))
                .setViewResolvers(viewResolver)
                .build();

        List<Department> departments = new ArrayList<>();
        departments.add(new Department(1, "Dept name 1", "Dept location 1"));
        departments.add(new Department(2, "Dept name 2", "Dept location 2"));
        doReturn(departments).when(departmentServices).listDepartment();
    }

    @Test
    public void whenGoHomeThenOk() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/home").accept(MediaType.TEXT_PLAIN))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"));
    }

    @Test
    public void whenListDeptThenOk() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/deptList").accept(MediaType.TEXT_PLAIN))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attribute("departments", departmentServices.listDepartment()))
                .andExpect(MockMvcResultMatchers.view().name("deptList"));
    }
}