package dehbi.hr.Dao;

import dehbi.hr.Entite.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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
    @Modifying
    @Query("delete from Employee e where e.cin =:cin")
    @Transactional
    void deleteByCin(@Param("cin") String cin);
    @Modifying
    @Transactional
    @Query("update Employee e set e.manager =null where e.manager=:employee")
    void updateManager(@Param("employee") Employee employee);
    @Query("select e from Employee e where e.id=:id")
    Employee getEmployeeById(@Param("id") short id);
    @Query("select e from Employee e where e.email=:email and e.mot_de_passe=:password")
    Employee getEmployeeByEmailAndpassword(@Param("email")
       String email,@Param("password") String password);
}
