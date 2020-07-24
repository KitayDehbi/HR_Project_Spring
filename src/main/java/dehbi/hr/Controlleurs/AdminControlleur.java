package dehbi.hr.Controlleurs;

import dehbi.hr.Entite.Departement;
import dehbi.hr.Entite.Employee;
import dehbi.hr.Entite.Remuneration;
import dehbi.hr.Service.DepartementService;
import dehbi.hr.Service.EmployeeService;
import dehbi.hr.Service.RemunerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = {"/admin"})
public class AdminControlleur {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartementService departementService;

    @Autowired
    RemunerationService remunerationService;


    @GetMapping(value = {"/employees"})
    public String index( ModelMap model){
        List<Employee> liste = employeeService.listerEmployee();
        model.addAttribute("liste", liste);
        return "admin/Employee/index";
    }
    @GetMapping("/employees/add")
    public String add(ModelMap model,Employee employee) {
        model.addAttribute("employee", employee);
        model.addAttribute("departements",departementService.listerDepartement() );
        model.addAttribute("employees",employeeService.getAllEmployees());
        return "admin/Employee/add";
    }
    @GetMapping("/employees/add/{cin}")
    public String modifier(@PathVariable("cin") String  cin, ModelMap model ) {
        model.addAttribute("employee", employeeService.getEmployeeByCin(cin));
        model.addAttribute("departements",departementService.listerDepartement() );
        model.addAttribute("employees",employeeService.getAllEmployees());
        return "admin/Employee/add";
    }
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("employee") Employee employee, BindingResult result, ModelMap model) {
        if(result.hasErrors() /*&&employeeService.getEmployeeById(employee.getId())==null*/){
            model.addAttribute("departements",departementService.listerDepartement() );
            model.addAttribute("employee",employee);
            model.addAttribute("employees",employeeService.getAllEmployees());
            return "admin/Employee/add";
        }
        /*if (result.hasErrors() &&employeeService.getEmployeeById(employee.getId())!=null ){
            employeeService.updateManager(employeeService.getEmployeeByCin(employee.getCin()));
            employeeService.supprimmerEmployee(employee.getCin());
        }*/
        employee.setMot_de_passe(employee.getCin()+employee.getTel());
        employeeService.sendEmail(employee);
        employeeService.ajouterEmployee(employee);
        return "redirect:/admin/employees";
    }
    @RequestMapping("/employees/{cin}")
    public String view(@PathVariable("cin") String  cin, ModelMap model){
        model.addAttribute("employee",employeeService.getEmployeeByCin(cin));
        model.addAttribute("liste",employeeService.listerSousJacents(employeeService.getEmployeeByCin(cin).getId()));
        model.addAttribute("remunerations",employeeService.getEmployeeByCin(cin).getRemunerations());
        return "admin/Employee/view";
    }
    @GetMapping("/employees/delete/{cin}")
    public String delete(@PathVariable("cin") String cin, ModelMap model){
        employeeService.updateManager(employeeService.getEmployeeByCin(cin));
        employeeService.supprimmerEmployee(cin);
        return "redirect:/admin/employees";

    }
    @GetMapping(value = {"/departement"})
    public String indexDepartement( ModelMap model){
        List<Departement> liste = departementService.listerDepartement();
        model.addAttribute("liste", liste);
        return "admin/Departement/index";
    }
    @RequestMapping("/departement/{id}")
    public String viewDepartement(@PathVariable("id") short  id, ModelMap model){
        model.addAttribute("departement",departementService.getDepartementById(id));
        model.addAttribute("liste",departementService.getDepartementById(id).getEmployees());
        return "admin/Departement/view";
    }
    @GetMapping(value = {"/remuneration"})
    public String indexRemuneration( ModelMap model){
        List<Remuneration> liste = remunerationService.getAllRemuneration();
        model.addAttribute("liste", liste);
        return "admin/Remuneration/index";
    }
    @GetMapping("/remuneration/add")
    public String addRemuneration(ModelMap model, Remuneration remuneration) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("remuneration", remuneration);
        return "admin/Remuneration/add";
    }
    @PostMapping("/remuneration/save")
    public String saveRemuneration(@Valid @ModelAttribute("remuneration") Remuneration remuneration, BindingResult result, ModelMap model) {
        if(result.hasErrors() /*&&employeeService.getEmployeeById(employee.getId())==null*/){
            model.addAttribute("remuneration", remuneration);
            model.addAttribute("employees", employeeService.getAllEmployees());

            return "admin/Remuneration/add";
        }
        /*if (result.hasErrors() &&employeeService.getEmployeeById(employee.getId())!=null ){
            employeeService.updateManager(employeeService.getEmployeeByCin(employee.getCin()));
            employeeService.supprimmerEmployee(employee.getCin());
        }*/
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy");
        ;
       remuneration.setDate_remuneration(simpleDateFormat.format(new Date()));

        Employee e = employeeService.getEmployeeById(remuneration.getEmployee().getId());
        if (remuneration.getType().equals("fixe")) {
            remuneration.setMontant(e.getChiffre_affaire()*0.1);
        }else{
            remuneration.setMontant(e.getChiffre_affaire()*0.1);
        }
        remunerationService.saveRemuneration(remuneration);
        return "redirect:/admin/remuneration";
    }
    @GetMapping("/redirect")
    public String redirect(String st) {
        return "redirect:/"+st;
    }

}
