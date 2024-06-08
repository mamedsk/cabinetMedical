package ma.cabinet.enums;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public enum StatuPaiment {
    EN_ATTENTE,
    IMPAYE,
    PAYE;
    @Getter
    @Setter
    private String descrition;
}
