package tn.tekup.spring.uptowork;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import tn.tekup.spring.uptowork.entities.DetailEquipe;
import tn.tekup.spring.uptowork.entities.Equipe;
import tn.tekup.spring.uptowork.entities.Etudiant;
import tn.tekup.spring.uptowork.entities.Niveau;
import tn.tekup.spring.uptowork.repositories.DetailEquipeRepository;
import tn.tekup.spring.uptowork.repositories.EquipeRepository;
import tn.tekup.spring.uptowork.services.EquipeServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class EquipeServiceImplTest {
    @Mock
    EquipeRepository equipeRepository;
    @Mock
    DetailEquipeRepository detailEquipeRepository;
    @InjectMocks
    EquipeServiceImpl equipeServiceImpl;
    Equipe equipe1 = new Equipe(1, "Equipe1", Niveau.JUNIOR, new ArrayList<Etudiant>(), new DetailEquipe());
    List<Equipe> listEquipe = new ArrayList<Equipe>(){
        {
            add(new Equipe(1, "Equipe1", Niveau.JUNIOR, new ArrayList<Etudiant>(), new DetailEquipe()));
            add(new Equipe(2, "Equipe2", Niveau.JUNIOR, new ArrayList<Etudiant>(), new DetailEquipe()));
        }
    };
    @Test
    void retrieveAllEquipes() {
        System.out.println("In the function");
        // Mock the behavior of the repository
        when(equipeRepository.findAll()).thenReturn(listEquipe);

        // Call the method being tested
        System.out.println("Before calling retrieveAllEquipes()");
        List<Equipe> prods = equipeServiceImpl.retrieveAllEquipes();

        // Assert the result
        assertNotNull(prods);
    }

    @Test
    void addEquipe() {
        when(equipeRepository.save(equipe1)).thenReturn(equipe1);
        Equipe equipe = equipeServiceImpl.addEquipe(equipe1);
        assertNotNull(equipe);
    }

    @Test
    void updateEquipe() {
        Equipe equipe =new Equipe(1, "Equipe1", Niveau.JUNIOR, new ArrayList<Etudiant>(), new DetailEquipe());
        Mockito.when(equipeRepository.save(Mockito.any())).thenReturn(equipe);
        Equipe as=equipeServiceImpl.updateEquipe(equipe);
        assertEquals("Equipe1",as.getNomEquipe());
    }

    @Test
    void retrieveEquipe() {
        when(equipeRepository.findById(1)).thenReturn(Optional.of(equipe1));

// Call the method being tested
        System.out.println("Before calling testretrieveEquipe()");
        Equipe pr = equipeServiceImpl.retrieveEquipe(1);
        System.out.println("After calling testretrieveEquipe() => " + pr.getNomEquipe());

// Assert the result
        assertNotNull(pr);
    }


}