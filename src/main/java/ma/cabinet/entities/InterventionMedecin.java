package ma.cabinet.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class InterventionMedecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIntervention;

    private String nomMedecin;

    private Double prixPatient;
    private Long dent;
    private String typeIntervention;
    private String description;

    @ManyToOne
    @JoinColumn(name = "acte_id")
    private Acte acte;

    @ManyToOne
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;
}
