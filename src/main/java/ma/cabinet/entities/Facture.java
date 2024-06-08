package ma.cabinet.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.cabinet.enums.TypePaiement;

import java.time.LocalDate;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idfacture;

    private Double montantTotal;

    private LocalDate dateFacture;

    private Double montantPaye;

    private Double montantRestant;

    private LocalDate dateFacturation;



    @ManyToOne
    @JoinColumn(name = "situation_financiere_id")
    private SituationFinancier situationFinanciere;

    @Enumerated(EnumType.STRING)
    private TypePaiement typePaiement;

    @ManyToOne
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;
}
