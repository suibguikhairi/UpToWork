package tn.tekup.spring.uptowork.services;

import tn.tekup.spring.uptowork.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversites();

    Universite addUniversite (Universite  u);

    Universite updateUniversite (Universite  u);

    Universite retrieveUniversite (Integer idUniversite);

    void removeUniversite(Integer idUniversite);



    public void assignUniversiteToDepartement(Integer universiteId, Integer departementId) ;


}
