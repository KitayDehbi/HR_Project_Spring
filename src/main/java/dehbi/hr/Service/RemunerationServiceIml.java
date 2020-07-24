package dehbi.hr.Service;

import dehbi.hr.Dao.RemunerationDao;
import dehbi.hr.Entite.Remuneration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemunerationServiceIml implements RemunerationService{
    @Autowired
    RemunerationDao remunerationDao;
    @Override
    public void saveRemuneration(Remuneration remuneration) {
    remunerationDao.save(remuneration);
    }

    @Override
    public List<Remuneration> getAllRemuneration() {
        return remunerationDao.findAll();
    }
}
