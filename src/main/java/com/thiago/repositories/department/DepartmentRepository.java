package com.thiago.repositories.department;

import com.thiago.model.entity.Department;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Thiago Lima on 2016-05-19.
 */
public interface DepartmentRepository extends CrudRepository<Department, Integer> {

    @Query("SELECT max(d.deptId) FROM Department d ")
    Integer getMaxId();
}
