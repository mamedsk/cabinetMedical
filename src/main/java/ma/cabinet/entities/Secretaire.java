package ma.cabinet.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.cabinet.enums.Assurance;
import ma.cabinet.enums.StatusEmploye;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Secretaire extends User{
    private Double salaireDeBase;
    private Double prime;

    @Enumerated(EnumType.STRING)
    private Assurance assurance;

    @Enumerated(EnumType.STRING)
    private StatusEmploye statutActuel;
}
