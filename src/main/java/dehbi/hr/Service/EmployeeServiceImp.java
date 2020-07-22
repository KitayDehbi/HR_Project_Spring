package dehbi.hr.Service;

import dehbi.hr.Dao.EmployeeDao;
import dehbi.hr.Entite.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService{
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional
    public void ajouterEmployee(Employee e) {
        employeeDao.save(e);
    }

    @Override
    @Transactional
    public void supprimmerEmployee(short id) {
        employeeDao.deleteById(id);
    }

    @Override
    public List<Employee> listerEmployee() {
        return employeeDao.findAll();
    }

    @Override
    public List<Employee> listerSousJacents(short id) {
        return employeeDao.listerSousJacents(id);
    }

    @Override
    public Employee getEmployeeByCin(String cin) {
        return employeeDao.getEmployeeByCin(cin);
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        return employeeDao.getEmployeeByEmail(email);
    }

    @Override
    public Employee getEmployeeByTel(String tel) {
        return employeeDao.getEmployeeByTel(tel);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }


}
