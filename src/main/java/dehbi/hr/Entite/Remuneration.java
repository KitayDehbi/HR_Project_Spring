package dehbi.hr.Entite;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "remunerations")
public class Remuneration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;
    private String type;
    private double montant;
    private String date_remuneration;
    @ManyToOne
    private Employee employee;
}
