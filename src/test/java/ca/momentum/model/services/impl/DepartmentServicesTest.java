package ca.momentum.model.services.impl;

import ca.momentum.BaseTestConfig;
import ca.momentum.model.entity.Department;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by Thiago Lima on 2016-05-12.
 */
@Transactional
public class DepartmentServicesTest extends BaseTestConfig {

    @Autowired
    DepartmentServices departmentServices;

    Department department;

    @Before
    public void setUp() throws Exception {
        department = departmentServices.createDepartment("myDept", "Location");

        departmentServices.persistDepartment(department);
    }

    @Test
    public void givenPersistedDepartmentWhenListDepartmentSizeThenReturnFive() throws Exception {
        assertThat(departmentServices.listDepartment()).hasSize(1);
    }

    @Test
    public void givenPersistedDepartmentWhenGetMaxIdThenOk() throws Exception {
        assertThat(departmentServices.getMaxDeptId()).isEqualTo(department.getDeptId());
    }

    @Test
    public void givenPersistedDepartmentWhenCreatingDeptThenItCanBeRetrieved() throws Exception {

        Department retrievedDepartment = departmentServices.getDepartment(department.getDeptId());
        assertThat(department).isEqualTo(retrievedDepartment);
    }
}