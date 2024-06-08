package ma.cabinet.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.cabinet.enums.StatuPaiment;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SituationFinancier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateCreation;
    private Double montantGlobalPaye;
    private Double montantGlobalRestant;

    @OneToOne(mappedBy = "situationFinanciere")
    @JoinColumn(name = "dossierMedicale_id")
    private DossierMedicale dossierMedicale;

    @OneToMany(mappedBy = "situationFinanciere")
    private List<Facture> factures;


    @ManyToOne
    @JoinColumn(name = "caisse_id")
    private Caisse caisse;
}
