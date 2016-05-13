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

//    @Autowired
//    private DepartmentDAO departmentDAO;

    @Autowired
    private DepartmentServices departmentServices;

    @RequestMapping({ "/", "/home", "/index" })
    public String home(Model model) {
        return "index";
    }

//    @RequestMapping({ "/deptList" })
//    public String deptList(Model model) {
//        departmentDAO.createDepartment("Dept Name", "Dept Location");
//
//        List<Department> list = departmentDAO.listDepartment();
//        for (Department dept : list) {
//            System.out.println("Dept No " + dept.getDeptNo());
//        }
//        model.addAttribute("departments", list);
//        return "deptList";
//    }

    @RequestMapping({ "/deptList" })
    public String deptList(Model model) {
//        departmentServices.createDepartment("Dept Name", "Dept Location");

        List<Department> list = departmentServices.listDepartment();
        for (Department dept : list) {
            System.out.println("Dept No " + dept.getDeptNo());
        }
        model.addAttribute("departments", list);
        return "deptList";
    }

    public DepartmentServices getDepartmentServices() {
        return departmentServices;
    }
}
