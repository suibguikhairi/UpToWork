package tn.tekup.spring.uptowork;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import tn.tekup.spring.uptowork.entities.DetailEquipe;
import tn.tekup.spring.uptowork.entities.Equipe;
import tn.tekup.spring.uptowork.entities.Etudiant;
import tn.tekup.spring.uptowork.entities.Niveau;
import tn.tekup.spring.uptowork.repositories.EquipeRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
 class EquipeTest {

    @Autowired
    private EquipeRepository equipeRepository;


    @Test
     void testEquipeCreation() {
        Equipe equipe = new Equipe();
        equipe.setNomEquipe("TestEquipe");
        equipe.setNiveau(Niveau.JUNIOR);

        DetailEquipe detailEquipe = new DetailEquipe();
        // Set details for detailEquipe if needed
        equipe.setDetailEquipe(detailEquipe);

        List<Etudiant> etudiants = new ArrayList<>();
        // Add etudiants to the list if needed
        equipe.setEtudiants(etudiants);

        Equipe savedEquipe = equipeRepository.save(equipe);

        assertNotNull(savedEquipe.getIdEquipe());
        assertEquals("TestEquipe", savedEquipe.getNomEquipe());
        assertEquals(Niveau.JUNIOR, savedEquipe.getNiveau());
        assertEquals(detailEquipe, savedEquipe.getDetailEquipe());
        assertEquals(etudiants, savedEquipe.getEtudiants());
    }

    // Add more test methods as needed to cover other functionalities of the Equipe class
}