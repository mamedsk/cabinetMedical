package ma.cabinet.repository;

import ma.cabinet.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFactureRepository extends JpaRepository<Facture,Long> {
}
