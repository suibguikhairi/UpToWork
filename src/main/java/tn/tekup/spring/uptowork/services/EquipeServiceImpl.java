package tn.tekup.spring.uptowork.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.tekup.spring.uptowork.entities.Equipe;
import tn.tekup.spring.uptowork.repositories.ContratRepository;
import tn.tekup.spring.uptowork.repositories.EquipeRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class EquipeServiceImpl implements IEquipeService {
    EquipeRepository equipeRepository;
    ContratRepository contratRepository;

    @Override
    public List<Equipe> retrieveAllEquipes() {
        return equipeRepository.findAll();
    }

    @Transactional
    public Equipe addEquipe(Equipe e) {

        equipeRepository.save(e);
        return e;
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe retrieveEquipe(Integer idEquipe) {
        return equipeRepository.findById(idEquipe).orElse(null);
    }



}
