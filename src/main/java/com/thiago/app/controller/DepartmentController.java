package com.thiago.app.controller;

import com.thiago.app.validators.DepartmentFormValidator;
import com.thiago.model.entity.Department;
import com.thiago.model.services.impl.DepartmentServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @RequestMapping({"/dept/list/{pageNumber}"})
    public String deptList(@PathVariable Integer pageNumber, Model model) {
        logger.info("list");

        configurePagination(pageNumber, model);

        return "deptListPage";
    }

    private void configurePagination(@PathVariable Integer pageNumber, Model model) {
        Page<Department> page = departmentServices.listDepartment(pageNumber);

        logger.info("pageNumber: " + pageNumber);
        logger.info("getTotalPages: " + page.getTotalPages());
        if (pageNumber > page.getTotalPages() && page.getTotalPages() > 0) {
            pageNumber--;
            page = departmentServices.listDepartment(pageNumber);
        }

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());


        int startIndexPage = (page.getNumberOfElements() * pageNumber) - (page.getNumberOfElements() - 1);
        if (page.isLast() && page.getTotalElements() % page.getTotalPages() != 0){
            startIndexPage = (int)page.getTotalElements() - page.getNumberOfElements() +1;
        }

        model.addAttribute("startIndexPage", startIndexPage);
        model.addAttribute("departments", page.getContent());
        model.addAttribute("departmentPage", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("test", "testThiago");
    }

    @RequestMapping({"/createDept"})
    public String createDept(Model model) {
        logger.info("createDept");
        Department department = departmentServices.createDepartment("Dept Name", "Dept Location");
        departmentServices.save(department);
        return "forward:/dept/list/1";
    }

    //Set a form validator
    @InitBinder("department")
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(departmentFormValidator);
    }

    @RequestMapping({"/dept/add"})
    public String deptForm(Model model) {
        logger.info("add");

        Department department = new Department();
        model.addAttribute("department", department);

        return "deptFormPage";
    }

    @RequestMapping({"/dept/edit/id={id}"})
    public String deptForm(@PathVariable String id, Model model) {
        logger.info("update");

        Department department = departmentServices.getDepartmentById(Integer.parseInt(id));
        model.addAttribute("department", department);

        return "deptFormPage";
    }

    @RequestMapping({"/dept/delete/page={pageNumber}&id={id}"})
    public String delete(@PathVariable Integer id, @PathVariable Integer pageNumber, Model model) {
        logger.info("update");

        Department department = departmentServices.getDepartmentById(id);
        departmentServices.delete(department);

        configurePagination(pageNumber, model);

        return "deptListPage";
//        return "forward:/dept/list/"+pageNumber;
    }

    @RequestMapping(value = "/saveOrUpdateDept", method = RequestMethod.POST)
    public String saveOrUpdateUser(@ModelAttribute("department") @Validated Department department,
                                   BindingResult result, Model model,
                                   final RedirectAttributes redirectAttributes) {
        logger.info("saveOrUpdateUser");

        if (result.hasErrors()) {
            return "deptFormPage";
        } else {

            // Add message to flash scope
            redirectAttributes.addFlashAttribute("css", "success");
            int id;
            if (department.getDeptId() == 0) {
                id = Math.abs(UUID.randomUUID().hashCode());
                redirectAttributes.addFlashAttribute("msg", "User added successfully!");
            } else {
                id = department.getDeptId();
                redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
            }
            department.setDeptId(id);
            department.setDeptNo("D" + id);
            department.setDeptName(department.getDeptName());
            department.setLocation(department.getLocation());
            departmentServices.save(department);

            // POST/REDIRECT/GET
            return "redirect:/dept/id=" + department.getDeptId();

            // POST/FORWARD/GET
            // return "user/list";

        }
    }

    @RequestMapping(value = "/dept/id={id}", method = RequestMethod.GET)
    public String showDept(@PathVariable String id, Model model) {
        logger.info("showDept");

        Department department = departmentServices.getDepartmentById(Integer.parseInt(id));
        model.addAttribute("department", department);

        return "showDeptPage";
    }
}