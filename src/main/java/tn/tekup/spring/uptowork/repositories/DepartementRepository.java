package tn.tekup.spring.uptowork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.tekup.spring.uptowork.entities.Departement;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, Integer> {
}
