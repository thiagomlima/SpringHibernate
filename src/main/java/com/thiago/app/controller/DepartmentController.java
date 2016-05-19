package com.thiago.app.controller;

import com.thiago.app.validators.DepartmentFormValidator;
import com.thiago.model.entity.Department;
import com.thiago.model.services.impl.DepartmentServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Thiago Lima on 2016-05-19.
 */
@Controller
public class DepartmentController {

    private final static Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    DepartmentFormValidator departmentFormValidator;

    private DepartmentServices departmentServices;

    @Autowired
    public DepartmentController(DepartmentServices departmentServices, DepartmentFormValidator departmentFormValidator) {
        this.departmentServices = departmentServices;
        this.departmentFormValidator = departmentFormValidator;
    }

    @RequestMapping({"/deptList"})
    public String deptList(Model model) {
        logger.info("createDept");
        List<Department> list = departmentServices.listDepartment();
        for (Department dept : list) {
            System.out.println("Dept No " + dept.getDeptNo());
        }
        model.addAttribute("departments", list);
        return "deptListPage";
    }

    @RequestMapping({"/createDept"})
    public String createDept(Model model) {
        logger.info("createDept");
        Department department = departmentServices.createDepartment("Dept Name", "Dept Location");
        departmentServices.save(department);
        return "forward:deptListPage";
    }

    //Set a form validator
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(departmentFormValidator);
    }

    @RequestMapping({" /dept/add"})
    public String deptForm(Model model) {
        logger.info("deptForm");

        Department department = new Department();
        department.setDeptName("test");
        model.addAttribute("department", department);

        return "deptFormPage";
    }

    @RequestMapping(value = "/saveOrUpdateDept", method = RequestMethod.POST)
    public String saveOrUpdateUser(@ModelAttribute("department") @Validated Department department,
                                   BindingResult result, Model model,
                                   final RedirectAttributes redirectAttributes) {

        logger.info("saveOrUpdateUser");
        logger.debug("saveOrUpdateUser() : {}", department);


        System.out.println(model.asMap().size());
        for (Map.Entry<String, Object> stringObjectEntry : model.asMap().entrySet()) {
            System.out.println(stringObjectEntry.getKey() + " - " + stringObjectEntry.getValue());
        }

        if (result.hasErrors()) {
            return "deptFormPage";
        } else {

            // Add message to flash scope
            redirectAttributes.addFlashAttribute("css", "success");
//            if(department.isNew()){
//                redirectAttributes.addFlashAttribute("msg", "User added successfully!");
//            }else{
//                redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
//            }
            int id = Math.abs(UUID.randomUUID().hashCode());
            department.setDeptId(id);
            department.setDeptNo("D" + id);
            department.setLocation("Location" + id);
            departmentServices.save(department);

            // POST/REDIRECT/GET
            return "redirect:/dept/" + department.getDeptId();

            // POST/FORWARD/GET
            // return "user/list";

        }
    }

    @RequestMapping(value = " /dept/{id}", method = RequestMethod.GET)
    public String showDept(@PathVariable String id) {
        logger.info("showDept");

        Department department = departmentServices.getDepartmentById(Integer.parseInt(id));


//        Department department = new Department();
//        department.setDeptName("test");
//        model.addAttribute("department", department);

        return "indexPage";
    }
}
