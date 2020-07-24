package dehbi.hr.Service;

import dehbi.hr.Entite.Departement;

import java.util.List;

public interface DepartementService {
    public List<Departement> listerDepartement();
    public Departement getDepartementById(short id);
}
