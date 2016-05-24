package com.thiago.app.validators;

import com.thiago.model.entity.Department;
import com.thiago.model.services.impl.DepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Thiago Lima on 2016-05-18.
 */
@Component
public class DepartmentFormValidator implements Validator {

    //TODO Thiago
//    @Autowired
//    @Qualifier("emailValidator")
//    EmailValidator emailValidator;

    @Autowired
    DepartmentServices departmentServices;

    @Override
    public boolean supports(Class<?> aClass) {
        return Department.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Department department = (Department) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "deptName", "NotEmpty.userForm.name");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.userForm.email");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty.userForm.address");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.userForm.password");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword","NotEmpty.userForm.confirmPassword");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex", "NotEmpty.userForm.sex");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "NotEmpty.userForm.country");

//        if(!emailValidator.valid(department.getEmail())){
//            errors.rejectValue("email", "Pattern.userForm.email");
//        }

        if(department.getDeptName()==null){
            errors.rejectValue("deptName", "deptForm.notEmpty.deptName");
        }
    }
}
