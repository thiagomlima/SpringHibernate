package ca.momentum.controller;

import ca.momentum.dao.DepartmentDAO;
import ca.momentum.entity.Department;
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
    private DepartmentDAO departmentDAO;

    @RequestMapping({ "/", "/home", "/index" })
    public String home(Model model) {
        return "index";
    }

    @RequestMapping({ "/deptList" })
    public String deptList(Model model) {
        departmentDAO.createDepartment("Dept Name", "Dept Location");

        List<Department> list = departmentDAO.listDepartment();
        for (Department dept : list) {
            System.out.println("Dept No " + dept.getDeptNo());
        }
        model.addAttribute("departments", list);
        return "deptList";
    }
}
