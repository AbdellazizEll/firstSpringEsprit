package tn.esprit.firstspring.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.firstspring.entities.DetailEquipe;
import tn.esprit.firstspring.repository.DetailEquipeRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class DetailEquipeImp implements IDetailEquipeService {


    DetailEquipeRepository detailEquipeRepository;
    @Override
    public List<DetailEquipe> getAllDetailEquipes() {
        return detailEquipeRepository.findAll();
    }

    @Override
    public DetailEquipe addDetailEquipe(DetailEquipe de) {
        return detailEquipeRepository.save(de);
    }

    @Override
    public tn.esprit.firstspring.entities.DetailEquipe updateDetailEquipe(DetailEquipe de) {
        return detailEquipeRepository.save(de);
    }

    @Override
    public void deleteDetailEquipe(int id) {
    detailEquipeRepository.deleteById(id);
    }

    @Override
    public DetailEquipe getDetailEquipeById(int id) {
        return detailEquipeRepository.findById(id).orElse(null);
    }

    @Override
    public List<DetailEquipe> findByThematiqueLike(String thematique) {
        return detailEquipeRepository.findByThematiqueLike(thematique);
    }
}
