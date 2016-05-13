package ca.momentum.model.services.impl;

import ca.momentum.dao.DepartmentDAO;
import ca.momentum.model.entity.Department;
import ca.momentum.model.services.Services;
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

    DepartmentDAO departmentDAO;

    @Autowired
    public DepartmentServices(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    public List<Department> listDepartment() {
        return departmentDAO.listDepartment();
    }

    public Integer getMaxDeptId() {
        return departmentDAO.getMaxDeptId();
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

    public void persistDepartment(Department department) {
        departmentDAO.persitDepartment(department);
    }

    public Department getDepartment(int id) {
        return departmentDAO.getDepartmentById(id);
    }

    public DepartmentDAO getDepartmentDAO() {
        return departmentDAO;
    }
}
