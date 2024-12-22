package tn.tekup.spring.uptowork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.tekup.spring.uptowork.entities.Departement;
import tn.tekup.spring.uptowork.entities.Universite;



@Repository
public interface UniversiteRepository extends JpaRepository<Universite, Integer> {
    public Universite findByNomUniv(String nomUniv);
    public Universite findByDepartements(Departement departement);


}
