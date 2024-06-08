package ma.cabinet.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.cabinet.enums.GroupeSanguin;
import ma.cabinet.enums.Mutuelle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient extends Person{
    private LocalDate dateNaissance;
    private String profession;

    @Enumerated(EnumType.STRING)
    private Mutuelle mutuelle;

    @Enumerated(EnumType.STRING)
    private GroupeSanguin groupeSanguin;

    @ManyToMany
    @JoinTable(
            name = "patinet_antecedents",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "antecedentmed_id")
    )
    private List<AntecedentsMedicaux> antecedentsMedicaux;

    @OneToOne
    @JoinColumn(name = "dossierMedicale_id")
    private DossierMedicale dossierMedicale;

    @Override
    public String toString() {
        return "Patient{id=" + getId() + ", name=" + getNom() + ", dossierMedicaleId=" + dossierMedicale.getId() + "}";
    }



}
