package tn.tekup.spring.uptowork.dto;

import lombok.Getter;
import lombok.Setter;
import tn.tekup.spring.uptowork.entities.Equipe;

import javax.persistence.OneToOne;

@Getter
@Setter
public class DetailEquipeDTO {
    private Integer idDetailEquipe;
    private Integer salle;
    private String thematique;
    @OneToOne
    private Equipe equipe;
}
