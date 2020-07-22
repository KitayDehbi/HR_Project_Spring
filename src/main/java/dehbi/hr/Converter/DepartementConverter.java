package dehbi.hr.Converter;

import dehbi.hr.Entite.Departement;
import org.hibernate.engine.config.spi.ConfigurationService;
import org.springframework.core.convert.converter.Converter;

public class DepartementConverter implements Converter<String, Departement> {
    @Override
    public Departement convert(String source) {
        if (source.isEmpty()) return null;
        else {
            return new Departement(Short.parseShort(source));
        }
    }
}
