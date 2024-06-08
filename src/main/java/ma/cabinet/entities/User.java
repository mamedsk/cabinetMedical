package ma.cabinet.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User extends Person {
    private String nomUser;
    private String motDePasse;

    @OneToMany(mappedBy = "utilisateur")
    private List<Role> roles;



}
