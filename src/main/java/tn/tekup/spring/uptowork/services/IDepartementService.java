package tn.tekup.spring.uptowork.services;

import tn.tekup.spring.uptowork.entities.Departement;

import java.util.List;

public interface IDepartementService {
    List<Departement> retrieveAllDepartements();
    Departement addDepartement(Departement d);
    Departement updateDepartement(Departement d);
    Departement retrieveDepartement(Integer idDepart);
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);


}
