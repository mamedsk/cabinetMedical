package ma.cabinet.entities;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.cabinet.enums.CategorieActe;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Acte {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idActe;

    private String libelle;

    private Double prixDeBase;

    private CategorieActe categorie;


    @OneToMany(mappedBy = "acte")
    private List<InterventionMedecin> interventions;



}
