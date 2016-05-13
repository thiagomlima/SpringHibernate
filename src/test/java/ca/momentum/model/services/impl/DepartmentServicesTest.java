package ca.momentum.model.services.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by Thiago Lima on 2016-05-12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/*-cfg.xml", "file:src/main/webapp/WEB-INF/*-servlet.xml" })
public class DepartmentServicesTest extends AbstractJUnit4SpringContextTests  {

    @Autowired
    DepartmentServices departmentServices;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    @Transactional
    public void whenListDepartmentSizeThenReturnFive() throws Exception {
        assertThat(departmentServices.listDepartment()).hasSize(13);
    }
}