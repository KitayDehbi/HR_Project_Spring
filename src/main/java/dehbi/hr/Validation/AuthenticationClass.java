package dehbi.hr.Validation;


import dehbi.hr.Service.EmployeeService;
import dehbi.hr.helpers.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AuthenticationClass implements ConstraintValidator<Authentication, AuthUser> {
    @Autowired
    private EmployeeService service;
    @Override
public boolean isValid(AuthUser value, ConstraintValidatorContext context) {
    return service.isExist(value.getEmail(),value.getPassword());
}
}
