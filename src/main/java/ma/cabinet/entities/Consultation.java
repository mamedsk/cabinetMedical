package ma.cabinet.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.cabinet.enums.TypeConsultation;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateConsultation;


    @Enumerated(EnumType.STRING)
    private TypeConsultation typeConsultation;

    @ManyToOne
    @JoinColumn(name = "dossier_medicale_id")
    private DossierMedicale dossierMedicale;

    @OneToMany(mappedBy = "consultation")
    private List<InterventionMedecin> interventions;

    @OneToMany(mappedBy = "consultation")
    private List<Facture> factures;



}
