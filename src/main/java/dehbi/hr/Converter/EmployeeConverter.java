package dehbi.hr.Converter;

import dehbi.hr.Entite.Departement;
import dehbi.hr.Entite.Employee;
import org.springframework.core.convert.converter.Converter;

public class EmployeeConverter implements Converter<String, Employee> {
    @Override
    public Employee convert(String source) {
        if (source.isEmpty()) return null;
        else {
            return new Employee(Short.parseShort(source));
        }
    }
}
