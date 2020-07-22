package dehbi.hr.Validation;

import dehbi.hr.Entite.Employee;
import dehbi.hr.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailClass implements ConstraintValidator<UniqueEmail, Employee> {
   @Autowired
   EmployeeService employeeService;

   public boolean isValid(Employee obj, ConstraintValidatorContext context) {
      try {

         return employeeService.getEmployeeByEmail(obj.getEmail())==null;
      } catch (Exception e)
      {
         return true;
      }
   }
}
