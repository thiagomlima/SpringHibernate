package ca.momentum.model.services.impl;

import ca.momentum.model.entity.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by Thiago Lima on 2016-05-12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager="txManager")
@Transactional
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/*-cfg.xml", "file:src/main/webapp/WEB-INF/*-servlet.xml" })
public class DepartmentServicesTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    DepartmentServices departmentServices;

    @Test
    public void whenListDepartmentSizeThenReturnFive() throws Exception {
        assertThat(departmentServices.listDepartment()).hasSize(13);
    }

    @Test
    public void whenGetMaxIdThenOk() throws Exception {
        assertThat(departmentServices.getMaxDeptId()).isEqualTo(13);
    }

    @Test
    public void givenDepartmentWhenCreatingDeptThenItCanBeRetrieved() throws Exception {
        Department department = departmentServices.createDepartment("myDept", "Location");

        departmentServices.persistDepartment(department);

        Department retrievedDepartment = departmentServices.getDepartment(department.getDeptId());
        assertThat(department).isEqualTo(retrievedDepartment);
    }
}