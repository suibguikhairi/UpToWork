package tn.tekup.spring.uptowork.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.tekup.spring.uptowork.entities.DetailEquipe;
import tn.tekup.spring.uptowork.entities.Equipe;
import tn.tekup.spring.uptowork.repositories.DetailEquipeRepository;
import tn.tekup.spring.uptowork.repositories.EquipeRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DetailEquipeServiceImpl implements IDetailEquipeService {
    EquipeRepository equipeRepository;
    DetailEquipeRepository detailEquipeRepository;



    @Override
    public List<DetailEquipe> retrieveAllDetailEquipe() {
        return this.detailEquipeRepository.findAll();
    }

    @Override
    public DetailEquipe addDetailEquipe(DetailEquipe d) {
        detailEquipeRepository.save(d);
        return d;
    }

    @Override
    public DetailEquipe updateDetailEquipe(DetailEquipe d) {
        if (d.getIdDetailEquipe() != null) {
            detailEquipeRepository.save(d);
            return d;
        } else {
            throw new IllegalArgumentException("Cannot update a non-persisted DetailEquipe.");
        }
    }

    @Override
    public DetailEquipe retrieveDetailEquipe(Integer idDetailEquipe) {
        return detailEquipeRepository.findById(idDetailEquipe).orElse(null);
    }

    @Override
    public DetailEquipe retrieveDetailEquipeByEquipeId(Integer idEquipe) {
        Optional<Equipe> equipeOptional = equipeRepository.findById(idEquipe);
        return equipeOptional.map(Equipe::getDetailEquipe).orElse(null);
    }

    @Override
    public DetailEquipe addEquipeToDetailEquipe(int idEquipe, int idDetail) {
        Optional<Equipe> equipeOptional = equipeRepository.findById(idEquipe);
        Optional<DetailEquipe> detailEquipeOptional = detailEquipeRepository.findById(idDetail);
        if (!detailEquipeOptional.isPresent() || !equipeOptional.isPresent()) {
            return null;
        }
        DetailEquipe detailEquipe = detailEquipeOptional.get();
        Equipe equipe = equipeOptional.get();
        equipe.setDetailEquipe(detailEquipe);
        equipeRepository.save(equipe);
        detailEquipe.setEquipe(equipe);
        detailEquipeRepository.save(detailEquipe);
        return detailEquipe;
    }

}
