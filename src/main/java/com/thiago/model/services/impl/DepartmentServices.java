package com.thiago.model.services.impl;

import com.thiago.model.entity.Department;
import com.thiago.model.services.Services;
import com.thiago.repositories.department.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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


    private static final int PAGE_SIZE = 5;

    DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServices(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> listDepartment() {
        return departmentRepository.findAll();
    }

    public Page<Department> listDepartment(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "deptName");
        return departmentRepository.findAll(request);
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

    public void delete(Department department) {
        departmentRepository.delete(department);
    }

    public Department getDepartmentById(int id) {
        return departmentRepository.findOne(id);
    }
}
