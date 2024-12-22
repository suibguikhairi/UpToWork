package tn.tekup.spring.uptowork.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.tekup.spring.uptowork.dto.UniversiteDTO;
import tn.tekup.spring.uptowork.entities.Universite;
import tn.tekup.spring.uptowork.services.IUniversiteService;
import java.util.List;

@Tag(name = "Gestion des universités")
@RestController
@RequestMapping("/universite")
@AllArgsConstructor
public class UniversiteRestController {


     IUniversiteService universiteService;


    // http://localhost:8089/Kaddem/universite/retrieve-all-universites
    @GetMapping("/retrieve-all-universites")
    @Operation(description = "récupérer la liste des universités")
    @ResponseBody
    public List<Universite> getUniversites() {
        return universiteService.retrieveAllUniversites();
    }

    // http://localhost:8089/Kaddem/universite/retrieve-universite/8
    @GetMapping("/retrieve-universite/{universite-id}")
    @Operation(description = "récupérer une université par son id")
    @ResponseBody
    public Universite retrieveUniversite(@PathVariable("universite-id") Integer universiteId) {
        return universiteService.retrieveUniversite(universiteId);
    }

    // http://localhost:8089/Kaddem/universite/add-universite
    @PostMapping("/add-universite")
    @Operation(description = "ajouter une université")
    @ResponseBody
    public Universite addUniversite(@RequestBody UniversiteDTO u) {
        Universite universite = new Universite(u.getIdUniversite(),u.getNomUniv(),u.getDepartements());
        return universiteService.addUniversite(universite);
    }

    // http://localhost:8089/Kaddem/universite/update-universite
    @PutMapping("/update-universite")
    @Operation(description = "modifier une université")
    @ResponseBody
    public Universite updateUniversite(@RequestBody UniversiteDTO u) {
        Universite universite = new Universite(u.getIdUniversite(),u.getNomUniv(),u.getDepartements());
        return universiteService.updateUniversite(universite);
    }

    @DeleteMapping("/removeUniversite/{idUniversite}")
    @ResponseBody
    public void removeUniversite(@PathVariable("idUniversite") Integer idUniversite) {
        universiteService.removeUniversite(idUniversite);
    }

    //   http://localhost:8089/Kaddem/universite/assignUniversiteToDepartement/1/1
    @PutMapping("/assignUniversiteToDepartement/{universiteId}/{departementId}")
    @Operation(description = "assigner une université à un département")
    @ResponseBody
    public void assignUniversiteToDepartement(@PathVariable("universiteId") Integer universiteId,@PathVariable("departementId") Integer departementId) {
        universiteService.assignUniversiteToDepartement(universiteId,departementId);
    }
}
