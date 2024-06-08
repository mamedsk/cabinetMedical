package ma.cabinet.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.cabinet.enums.Assurance;
import ma.cabinet.enums.Disponibilite;
import ma.cabinet.enums.Specialite;
import ma.cabinet.enums.StatusEmploye;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dentist extends User{
    private LocalDate dateRetourConge;
    private Double salaireDeBase;

    @Enumerated(EnumType.STRING)
    private Specialite specialite;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Map<DayOfWeek, Disponibilite> disponibilite;

    @Enumerated(EnumType.STRING)
    private Assurance assurance;

    @Enumerated(EnumType.STRING)
    private StatusEmploye statutActuel;

    @OneToMany(mappedBy = "dentist")
    private List<DossierMedicale> dossierMedicales;






}
