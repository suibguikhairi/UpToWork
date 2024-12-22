package tn.tekup.spring.uptowork.services;

import tn.tekup.spring.uptowork.entities.DetailEquipe;

import java.util.List;

public interface IDetailEquipeService {
    List<DetailEquipe> retrieveAllDetailEquipe();

    DetailEquipe addDetailEquipe(DetailEquipe d);

    DetailEquipe updateDetailEquipe(DetailEquipe d);

    DetailEquipe retrieveDetailEquipe(Integer idDetailEquipe);

    DetailEquipe retrieveDetailEquipeByEquipeId(Integer idEquipe);

    DetailEquipe addEquipeToDetailEquipe(int idEquipe, int idDetail);

}
