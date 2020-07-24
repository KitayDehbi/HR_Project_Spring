package dehbi.hr.Service;

import dehbi.hr.Dao.EmployeeDao;
import dehbi.hr.Entite.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.mail.internet.AddressException;
import javax.transaction.Transactional;
import java.security.SecureRandom;
import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class EmployeeServiceImp implements EmployeeService{
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @org.springframework.transaction.annotation.Transactional
    @Modifying
    public void ajouterEmployee(Employee e) {
        employeeDao.save(e);
    }

    @Override
    @Transactional
    public void supprimmerEmployee(String cin) {
        employeeDao.deleteByCin(cin);
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

    @Override
    public Employee getEmployeeById(short id) {
        return employeeDao.getEmployeeById(id);
    }

    @Override
    public void updateManager(Employee employee) {
        employeeDao.updateManager(employee);
    }

    @Override
    public boolean isExist(String email, String password) {
        return employeeDao.getEmployeeByEmailAndpassword(email,password)!=null;
    }

    @Override
    public void sendEmail(Employee employee)  {
        final String username = "master4isi2019@gmail.com";
        final String password = "KitayDehbi";
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("master4isi2019@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse( employee.getEmail())
            );
            message.setSubject("votre mot de passe ");
            message.setText("pour se connecter a votre compte utilisez votre email,\n" +
                    "et comme mot de passe vous devrez utiliser votre cin suivi par votre numero de telephone");

            Transport.send(message);



        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }


}
