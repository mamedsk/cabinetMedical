package ma.cabinet.repository;

import ma.cabinet.entities.Acte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IActeRepository extends JpaRepository<Acte,Long> {
}
