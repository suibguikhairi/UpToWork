package tn.tekup.spring.uptowork.services;

import tn.tekup.spring.uptowork.entities.Equipe;

import java.util.List;

public interface IEquipeService {

    List<Equipe> retrieveAllEquipes();

    Equipe  addEquipe(Equipe  e);

    Equipe updateEquipe (Equipe  e);

    Equipe retrieveEquipe (Integer idEquipe);


}
