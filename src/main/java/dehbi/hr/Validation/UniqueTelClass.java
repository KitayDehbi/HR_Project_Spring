package dehbi.hr.Validation;

import dehbi.hr.Dao.EmployeeDao;
import dehbi.hr.Entite.Employee;
import dehbi.hr.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueTelClass implements ConstraintValidator<UniqueTel, Employee> {
   @Autowired
   EmployeeService employeeService;
   public boolean isValid(Employee obj, ConstraintValidatorContext context) {

      try {
         return employeeService.getEmployeeByTel(obj.getTel())==null;
      } catch (Exception e)
      {
         return true;
      }
   }
}
