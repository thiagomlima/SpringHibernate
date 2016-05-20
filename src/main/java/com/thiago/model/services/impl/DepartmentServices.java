package com.thiago.model.services.impl;

import com.thiago.model.entity.Department;
import com.thiago.model.services.Services;
import com.thiago.repositories.department.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by Thiago Lima on 2016-05-11.
 */
@Service
@Transactional
public class DepartmentServices implements Services {

    DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServices(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> listDepartment() {
        return (List<Department>) departmentRepository.findAll();
    }

    public Integer getMaxDeptId() {
        return departmentRepository.getMaxId();

    }

    public Department createDepartment(String name, String location) {
        int deptId = Math.abs((int) UUID.randomUUID().getLeastSignificantBits());
        Department dept = new Department();
        dept.setDeptId(deptId);
        dept.setDeptNo("D" + deptId);
        dept.setDeptName(name);
        dept.setLocation(location);
        return dept;
    }

    public void save(Department department) {
        departmentRepository.save(department);
    }

    public Department getDepartmentById(int id) {
        return departmentRepository.findOne(id);
    }
}
