package tn.tekup.spring.uptowork;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import tn.tekup.spring.uptowork.entities.*;
import tn.tekup.spring.uptowork.repositories.ContratRepository;
import tn.tekup.spring.uptowork.repositories.DepartementRepository;
import tn.tekup.spring.uptowork.repositories.EquipeRepository;
import tn.tekup.spring.uptowork.repositories.EtudiantRepository;
import tn.tekup.spring.uptowork.services.ContratServiceImpl;
import tn.tekup.spring.uptowork.services.DepartementServiceImpl;
import tn.tekup.spring.uptowork.services.EquipeServiceImpl;
import tn.tekup.spring.uptowork.services.EtudiantServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class EtudiantServiceImplTest {

    @Mock
    @Autowired
    private EquipeRepository equipeRepository;
    @Mock
    @Autowired
    private ContratRepository contratRepository;
    @Autowired
    @Mock
    EtudiantRepository etudiantRepository;
    @Autowired
    @Mock
    DepartementRepository departementRepository;
    @InjectMocks
    EtudiantServiceImpl etudiantService;
    @InjectMocks
    DepartementServiceImpl departementService;
    @InjectMocks
    ContratServiceImpl contratService;
    @InjectMocks
    EquipeServiceImpl equipeService;

    Etudiant e = new Etudiant(1, "sofien", "Bensalem", Option.GAMIX, new Departement(), new ArrayList<Equipe>(), new ArrayList<Contrat>());


    @Test
    void retrieveAllEtudiants() {
        List<Etudiant> etudiantList = etudiantService.retrieveAllEtudiants();
        Assertions.assertNotNull(etudiantList);
    }


    @Test
    void updateEtudiant() {
        when(etudiantRepository.save(any(Etudiant.class))).thenReturn(e);
        Etudiant result = etudiantService.updateEtudiant(e);
        verify(etudiantRepository, times(1)).save(e);
    }


    @Test
    void removeEtudiant() {
        etudiantService.removeEtudiant(1);
        Mockito.verify(etudiantRepository, times(1))
                .deleteById(1);
    }

    @Test
    void testRetrieveAllEtudiants() {
        // Arrange
        when(etudiantRepository.findAll()).thenReturn(new ArrayList<>());

        // Act
        List<Etudiant> etudiants = etudiantService.retrieveAllEtudiants();

        // Assert
        assertNotNull(etudiants);
        assertEquals(0, etudiants.size());

        // Verify
        verify(etudiantRepository, times(1)).findAll();
    }

    @Test
    void testAddEtudiant() {
        // Arrange
        Etudiant etudiantToAdd = new Etudiant(/* set properties */);

        // Act
        when(etudiantRepository.save(etudiantToAdd)).thenReturn(etudiantToAdd);
        Etudiant addedEtudiant = etudiantService.addEtudiant(etudiantToAdd);

        // Assert
        assertNotNull(addedEtudiant);
        // Add more assertions based on your requirements

        // Verify
        verify(etudiantRepository, times(1)).save(etudiantToAdd);
    }

}