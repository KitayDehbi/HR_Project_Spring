package dehbi.hr.Controlleurs;

import dehbi.hr.Entite.Departement;
import dehbi.hr.Entite.Employee;
import dehbi.hr.Service.DepartementService;
import dehbi.hr.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = {"/employee"})
public class EmployeeControlleur {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartementService departementService;
    @Autowired
    AuthetificationControlleur authetificationControlleur;
    @RequestMapping(value = {"/profile"})
    public String index(ModelMap model){
        Employee e =(Employee) authetificationControlleur.httpSession.getAttribute("user");
        Employee emp = employeeService.getEmployeeByCin(e.getCin());
        model.addAttribute("employee",emp);
        model.addAttribute("liste",employeeService.listerSousJacents(emp.getId()));
        model.addAttribute("remuneration",emp.getRemunerations());
        return "employees/index";
    }
    @RequestMapping(value = {"/departement"})
    public String departement(ModelMap model){
        List<Departement> liste = departementService.listerDepartement();
        model.addAttribute("liste", liste);
        return "employees/departement";
    }
    @RequestMapping("/departement/{id}")
    public String viewDepartement(@PathVariable("id") short  id, ModelMap model){
        model.addAttribute("departement",departementService.getDepartementById(id));
        model.addAttribute("liste",departementService.getDepartementById(id).getEmployees());
        return "employees/view";
    }

    @GetMapping("/redirect")
    public String redirect(String st) {
        return "redirect:/"+st;
    }

}
