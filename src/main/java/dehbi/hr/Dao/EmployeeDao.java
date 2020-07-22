package dehbi.hr.Dao;

import dehbi.hr.Entite.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends JpaRepository<Employee,Short> {
    @Query("select e from Employee e where e.manager.id=:id")
    public List<Employee> listerSousJacents(@Param("id") short id);

    @Query("select e from Employee e where e.cin=:cin")
    public Employee getEmployeeByCin(@Param("cin") String cin);
    @Query("select e from Employee e where e.email=:email")
    public Employee getEmployeeByEmail(@Param("email") String email);
    @Query("select e from Employee e where e.tel=:tel")
    public Employee getEmployeeByTel(@Param("tel") String tel);
    @Query("select e from Employee e where e.id  <>:id")
    public List<Employee> getAllExceptOne(@Param("id") short id);
}
