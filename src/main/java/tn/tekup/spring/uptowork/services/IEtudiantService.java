package tn.tekup.spring.uptowork.services;

import tn.tekup.spring.uptowork.entities.Etudiant;
import tn.tekup.spring.uptowork.entities.Niveau;
import tn.tekup.spring.uptowork.entities.Specialite;

import java.util.List;

public interface IEtudiantService {

    List<Etudiant> retrieveAllEtudiants();
    Etudiant addEtudiant(Etudiant e);
    Etudiant updateEtudiant(Etudiant e);
    Etudiant retrieveEtudiant(Integer idEtudiant);
    void removeEtudiant(Integer idEtudiant);


    List<Etudiant> findByDepartementIdDepartement(Integer idDepartement);

    List<Etudiant> findByEquipesNiveau(Niveau niveau);

    //JPQL
    List<Etudiant> retrieveEtudiantsByContratSpecialite(Specialite specialite);

    List<Etudiant> retrieveEtudiantsByContratSpecialiteSQL(String specialite);


    List<Etudiant> getEtudiantsByDepartement (Integer idDepartement);

}
