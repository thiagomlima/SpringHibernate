package ca.momentum.dao;

import ca.momentum.entity.Department;

import java.util.List;

/**
 * Created by Thiago Lima on 2016-05-10.
 */
public interface DepartmentDAO {

    List<Department> listDepartment() ;

    Integer getMaxDeptId();

    void createDepartment(String name,String location);
}
