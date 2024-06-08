package ma.cabinet.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.cabinet.enums.CategorieAntecedentMedicaux;
import ma.cabinet.enums.Risque;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AntecedentsMedicaux {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;


    private CategorieAntecedentMedicaux categorie;


    private Risque risque;

    @ManyToMany(mappedBy = "antecedentsMedicaux")
    private List<Patient> patient;


}
