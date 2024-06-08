package ma.cabinet.repository;

import ma.cabinet.entities.SituationFinancier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISituationFinancierRepository extends JpaRepository<SituationFinancier,Long> {
}
