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
public class DossierMedicale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateCreation;

    @OneToOne(mappedBy = "dossierMedicale")
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToOne
    @JoinColumn(name = "situation_financiere_id")
    private SituationFinancier situationFinanciere;

    @OneToMany(mappedBy = "dossierMedicale")
    private List<Consultation> consultations;


    private StatuPaiment statutPaiement;

    @ManyToOne
    @JoinColumn(name = "destist_id")
    private Dentist dentist;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DossierMedicale{id=").append(id);
        sb.append(", dateCreation=").append(dateCreation);
        sb.append(", patient=").append(patient != null ? patient.getId() : null);
        // Append other necessary fields without causing recursive calls
        sb.append('}');
        return sb.toString();
    }


}
