package ca.momentum.model.services.impl;

import ca.momentum.dao.DepartmentDAO;
import ca.momentum.model.entity.Department;
import ca.momentum.model.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Thiago Lima on 2016-05-11.
 */
@Service
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

    public void createDepartment(String name, String location) {
        Integer deptId = getMaxDeptId() + 1;
        Department dept = new Department();
        dept.setDeptId(deptId);
        dept.setDeptNo("D" + deptId);
        dept.setDeptName(name);
        dept.setLocation(location);
        departmentDAO.createDepartment(dept);
    }
}
