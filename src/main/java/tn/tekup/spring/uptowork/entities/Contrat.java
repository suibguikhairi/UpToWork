package tn.tekup.spring.uptowork.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import tn.tekup.spring.uptowork.controllers.ContratDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Builder
@Entity
public class Contrat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContrat;
    @Temporal(TemporalType.DATE)
    private Date dateDebutContrat;
    @Temporal(TemporalType.DATE)
    private Date dateFinContrat;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    private Boolean archived;
    private Integer montantContrat;
    @ManyToOne
    @JsonIgnore
    private  Etudiant etudiant;

    public Integer getIdContrat() {
        return idContrat;
    }

    public Date getDateDebutContrat() {
        return dateDebutContrat;
    }

    public Date getDateFinContrat() {
        return dateFinContrat;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public Boolean getArchived() {
        return archived;
    }

    public Integer getMontantContrat() {
        return montantContrat;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setIdContrat(Integer idContrat) {
        this.idContrat = idContrat;
    }

    public void setDateDebutContrat(Date dateDebutContrat) {
        this.dateDebutContrat = dateDebutContrat;
    }

    public void setDateFinContrat(Date dateFinContrat) {
        this.dateFinContrat = dateFinContrat;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public void setMontantContrat(Integer montantContrat) {
        this.montantContrat = montantContrat;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Contrat() {
    }

    @Override
    public String toString() {
        return "Contrat{" +
                "idContrat=" + idContrat +
                ", dateDebutContrat=" + dateDebutContrat +
                ", dateFinContrat=" + dateFinContrat +
                ", specialite=" + specialite +
                ", archived=" + archived +
                ", montantContrat=" + montantContrat +
                ", etudiant=" + etudiant +
                '}';
    }

    public Contrat(Integer idContrat, Date dateDebutContrat, Date dateFinContrat, Specialite specialite, Boolean archived, Integer montantContrat ,Etudiant etudiant) {
        this.idContrat = idContrat;
        this.dateDebutContrat = dateDebutContrat;
        this.dateFinContrat = dateFinContrat;
        this.specialite = specialite;
        this.archived = archived;
        this.montantContrat = montantContrat;
        this.etudiant = etudiant;
    }

    public Contrat(ContratDTO c) {
        this.idContrat = c.getIdContrat();
        this.dateDebutContrat = c.getDateDebutContrat();
        this.dateFinContrat = c.getDateFinContrat();
        this.specialite = c.getSpecialite();
        this.archived = c.getArchived();
        this.montantContrat = c.getMontantContrat();
        this.etudiant = c.getEtudiant();
    }
}
