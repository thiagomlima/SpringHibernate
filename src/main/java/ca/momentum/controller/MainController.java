package ca.momentum.controller;

import ca.momentum.model.entity.Department;
import ca.momentum.model.services.impl.DepartmentServices;
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

    @Autowired
    private DepartmentServices departmentServices;

    @Autowired
    public MainController(DepartmentServices departmentServices) {
        this.departmentServices = departmentServices;
    }

    @RequestMapping({ "/", "/home", "/index" })
    public String home(Model model) {
        return "index";
    }

    @RequestMapping({ "/deptList" })
    public String deptList(Model model) {
        List<Department> list = departmentServices.listDepartment();
        for (Department dept : list) {
            System.out.println("Dept No " + dept.getDeptNo());
        }
        model.addAttribute("departments", list);
        return "deptList";
    }

    @RequestMapping({ "/createDept" })
    public String createDept(Model model) {
        Department department = departmentServices.createDepartment("Dept Name", "Dept Location");
        departmentServices.persistDepartment(department);
        return "forward:deptList";
    }
}
