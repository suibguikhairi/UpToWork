package tn.tekup.spring.uptowork.dto;

import lombok.Getter;
import lombok.Setter;
import tn.tekup.spring.uptowork.entities.Contrat;
import tn.tekup.spring.uptowork.entities.Departement;
import tn.tekup.spring.uptowork.entities.Equipe;
import tn.tekup.spring.uptowork.entities.Option;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
public class EtudiantDTO {

    private Integer idEtudiant;
    private String prenomE;
    private String nomE;
    private Option op;

    private Departement departement;
    @ManyToMany
    private List<Equipe> equipes;
    @OneToMany(mappedBy = "etudiant")
    private List<Contrat> contrats;

}
