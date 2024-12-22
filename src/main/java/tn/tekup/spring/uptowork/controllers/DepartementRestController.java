package tn.tekup.spring.uptowork.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.tekup.spring.uptowork.dto.DepartementDTO;
import tn.tekup.spring.uptowork.entities.Departement;
import tn.tekup.spring.uptowork.services.DepartementServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/departement")
@AllArgsConstructor

public class DepartementRestController {

    DepartementServiceImpl departementService;

    // http://localhost:8089/Kaddem/departement/retrieve-all-departements
    @GetMapping("/retrieve-all-departements")
    @ResponseBody
    public List<Departement> getDepartements() {
        return departementService.retrieveAllDepartements();

    }

    // http://localhost:8089/Kaddem/departement/retrieve-departement/8
    @GetMapping("/retrieve-departement/{departement-id}")
    @ResponseBody
    public Departement retrieveDepartement(@PathVariable("departement-id") Integer departementId) {
        return departementService.retrieveDepartement(departementId);
    }

    // http://localhost:8089/Kaddem/departement/add-departement
    @PostMapping("/add-departement")
    @ResponseBody
    public Departement addDepartement(@RequestBody DepartementDTO d) {
        Departement departement = new Departement();
        departement.setNomDepart(d.getNomDepart());
        departement.setEtudiants(d.getEtudiants());
        return departementService.addDepartement(departement);


    }

    // http://localhost:8089/Kaddem/departement/update-departement
    @PutMapping("/update-departement")
    @ResponseBody
    public Departement updateDepartement(@RequestBody DepartementDTO d) {
        Departement departement = new Departement();
        departement.setNomDepart(d.getNomDepart());
        departement.setEtudiants(d.getEtudiants());
        return departementService.updateDepartement(departement);

    }


    // http://localhost:8089/Kaddem/departement/retrieveDepartementsByUniversite/1
    @GetMapping("/retrieveDepartementsByUniversite/{idUniversite}")
    @ResponseBody
    public List<Departement> retrieveDepartementsByUniversite(@PathVariable("idUniversite") Integer idUniversite) {
        return departementService.retrieveDepartementsByUniversite(idUniversite);

    }


}
