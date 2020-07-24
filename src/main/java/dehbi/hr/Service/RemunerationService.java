package dehbi.hr.Service;

import dehbi.hr.Entite.Remuneration;

import java.util.List;

public interface RemunerationService {

    public void saveRemuneration(Remuneration remuneration);

    List<Remuneration> getAllRemuneration();
}
