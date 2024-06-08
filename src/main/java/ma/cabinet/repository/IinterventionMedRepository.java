package ma.cabinet.repository;

import ma.cabinet.entities.InterventionMedecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IinterventionMedRepository extends JpaRepository<InterventionMedecin,Long> {
}
