package ma.cabinet.repository;

import ma.cabinet.entities.DossierMedicale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDossierMedRepository extends JpaRepository<DossierMedicale,Long> {
}
