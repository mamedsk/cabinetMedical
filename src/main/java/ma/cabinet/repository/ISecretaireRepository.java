package ma.cabinet.repository;

import ma.cabinet.entities.Secretaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISecretaireRepository extends JpaRepository<Secretaire,Long> {
}
