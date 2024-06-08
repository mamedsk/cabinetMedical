package ma.cabinet.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Caisse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double montantDuMois;
    private Double montantTotalAnnee;

    @OneToMany(mappedBy = "caisse")
    private List<SituationFinancier> situationsFinancieres;
}
