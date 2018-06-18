package com.lilyle.lotus.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lilyle.lotus.model.Customers;

@Component
public class CustomerValidator implements Validator {

    public boolean supports(Class<?> clazz) {
        return Customers.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
        Customers user = (Customers) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerName", "NotEmpty");
        if (user.getCustomerName().length() < 6 || user.getCustomerName().length() > 32) {
            errors.rejectValue("customerName", "Size.userForm.username");
        }
        
        /*if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }*/

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

       /* if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }*/
        
    }

}
