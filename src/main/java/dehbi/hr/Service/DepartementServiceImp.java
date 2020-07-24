package dehbi.hr.Service;

import dehbi.hr.Dao.DepartementDao;
import dehbi.hr.Entite.Departement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartementServiceImp implements DepartementService{
    @Autowired
    DepartementDao departementDao;
    @Override
    public List<Departement> listerDepartement() {
        return departementDao.findAll();
    }

    @Override
    @Transactional
    public Departement getDepartementById(short id) {
        return departementDao.getDepartementById(id);
    }
}
