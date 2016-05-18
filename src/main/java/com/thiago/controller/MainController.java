package com.thiago.controller;

import com.thiago.model.entity.Department;
import com.thiago.model.services.impl.DepartmentServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Thiago Lima on 2016-05-10.
 */
@Controller
public class MainController {

    private final static Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private DepartmentServices departmentServices;

    @Autowired
    public MainController(DepartmentServices departmentServices) {
        this.departmentServices = departmentServices;
    }

    @RequestMapping({ "/", "/home", "/index" })
    public String home(Model model) {
        logger.info("index");
        return "index";
    }

    @RequestMapping({ "/deptList" })
    public String deptList(Model model) {
        logger.info("createDept");
        List<Department> list = departmentServices.listDepartment();
        for (Department dept : list) {
            System.out.println("Dept No " + dept.getDeptNo());
        }
        model.addAttribute("departments", list);
        return "deptList";
    }

    @RequestMapping({ "/createDept" })
    public String createDept(Model model) {
        logger.info("createDept");
        Department department = departmentServices.createDepartment("Dept Name", "Dept Location");
        departmentServices.save(department);
        return "forward:deptList";
    }
}
