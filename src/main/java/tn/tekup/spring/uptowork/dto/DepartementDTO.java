package tn.tekup.spring.uptowork.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import tn.tekup.spring.uptowork.entities.Etudiant;

import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
public class DepartementDTO {
    private Integer idDepartement;
    private String nomDepart;
    @OneToMany(mappedBy = "departement")
    @JsonIgnore
    private List<Etudiant> etudiants;

}
