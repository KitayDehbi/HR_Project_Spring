package dehbi.hr.Dao;

import dehbi.hr.Entite.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DepartementDao extends JpaRepository<Departement,Short> {
    @Query("select  d from Departement d where d.id=:id")
    public Departement getDepartementById(@Param("id") short id);
}
