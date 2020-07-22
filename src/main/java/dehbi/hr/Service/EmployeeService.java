package dehbi.hr.Service;

import dehbi.hr.Entite.Employee;

import java.util.List;

public interface EmployeeService {
    public void ajouterEmployee(Employee e );
    public void supprimmerEmployee(short id);
    public List<Employee> listerEmployee();
    public List<Employee> listerSousJacents(short id);
    public Employee getEmployeeByCin(String cin);
    public Employee getEmployeeByEmail(String email);
    public Employee getEmployeeByTel(String tel);
    public List<Employee> getAllEmployees();

}
