package ma.cabinet.enums;

import lombok.Getter;
import lombok.Setter;


public enum CategorieAntecedentMedicaux {
    MALADIE_CHRONIQUE,
    CONTRE_INDICATION,
    AUTRE,
    MALADIE_HEREDITAIRE,
    ALLERGIE ;
    private Risque risque;
    @Setter
    @Getter
    private String description;


    public Risque getRisque() {
        return risque;
    }

}
