package dehbi.hr.Entite;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Table(name = "departements")
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    short id;
    private String name;
    private String type;
    @OneToMany(cascade= CascadeType.ALL ,fetch = FetchType.EAGER)
    @JoinColumn(name="departement_id" )
    private List<Employee> employees;
    public Departement(short id){
        this.id=id;
    }
}
