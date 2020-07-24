package dehbi.hr.Controlleurs;

import dehbi.hr.Entite.Employee;
import dehbi.hr.Service.EmployeeService;
import dehbi.hr.Validation.Authentication;
import dehbi.hr.helpers.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class AuthetificationControlleur {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    HttpSession httpSession;

    @RequestMapping("")
    public String index (ModelMap model , AuthUser user){
        model.addAttribute("user",user);
    return "Authetification/index";
    }
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("user") AuthUser user , BindingResult result){
        if(result.hasErrors()){
            return "Authetification/index";
        }
        Employee e=employeeService.getEmployeeByEmail(user.getEmail());
        httpSession.setAttribute("user", e);
        if(e.is_admin()){
            return "redirect:/admin/employees";
        }
        return "redirect:/employee/profile";


    }
}
