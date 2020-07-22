package dehbi.hr.Validation;

import dehbi.hr.Entite.Employee;
import dehbi.hr.Service.EmployeeService;
import dehbi.hr.Service.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCinClass implements ConstraintValidator<UniqueCin, Employee> {
   @Autowired
   EmployeeService employeeService;

   public boolean isValid(Employee obj, ConstraintValidatorContext context) {
      try {
         return employeeService.getEmployeeByCin(obj.getCin())==null;
      } catch (Exception e)
      {
         return true;
      }
   }
}
