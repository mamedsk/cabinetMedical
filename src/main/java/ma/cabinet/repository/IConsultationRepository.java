package ma.cabinet.repository;

import ma.cabinet.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
//@Component
public interface IConsultationRepository extends JpaRepository<Consultation,Long> {
}
