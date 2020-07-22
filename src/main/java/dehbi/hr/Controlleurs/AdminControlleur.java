package dehbi.hr.Controlleurs;

import dehbi.hr.Entite.Employee;
import dehbi.hr.Service.DepartementService;
import dehbi.hr.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = {"/admin"})
public class AdminControlleur {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartementService departementService;

    @GetMapping(value = {"/employees"})
    public String index( ModelMap model){
        List<Employee> liste = employeeService.listerEmployee();
        model.addAttribute("liste", liste);
        return "admin/index";
    }
    @GetMapping("/employees/add")
    public String add(ModelMap model,Employee employee) {
        model.addAttribute("employee", employee);
        model.addAttribute("departements",departementService.listerDepartement() );
        model.addAttribute("employees",employeeService.getAllEmployees());
        return "admin/add";
    }
    @PostMapping("/save")
    public String saveArticle(@Valid @ModelAttribute("employee") Employee employee, BindingResult result, ModelMap model) {
        if(result.hasErrors()){
            model.addAttribute("departements",departementService.listerDepartement() );
            model.addAttribute("employee",employee);
            model.addAttribute("employees",employeeService.getAllEmployees());
            return "admin/add";
        }
        employee.setMot_de_passe(employee.getCin()+employee.getTel());
       employeeService.ajouterEmployee(employee);
        return "redirect:/admin/employees";
    }
    @RequestMapping("/employees/{cin}")
    public String view(@PathVariable("cin") String  cin, ModelMap model){
        model.addAttribute("employee",employeeService.getEmployeeByCin(cin));
        model.addAttribute("liste",employeeService.listerSousJacents(employeeService.getEmployeeByCin(cin).getId()));
        return "admin/view";
    }
}
