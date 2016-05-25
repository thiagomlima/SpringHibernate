package com.thiago.repositories.department;

import com.thiago.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Thiago Lima on 2016-05-19.
 */
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query("SELECT max(d.deptId) FROM Department d ")
    Integer getMaxId();
}
