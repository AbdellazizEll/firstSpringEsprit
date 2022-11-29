package tn.esprit.firstspring.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.firstspring.entities.Universite;
import tn.esprit.firstspring.repository.UniversiteRepository;

import java.util.List;
@Service
@AllArgsConstructor

public class UniversiteServiceImp implements IUniversiteService {



    UniversiteRepository universiteRepository;
    @Override
    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public void deleteUniversite(int id) {
        universiteRepository.deleteById(id);
    }

    @Override
    public Universite getUniversiteById(int id) {
        return universiteRepository.findById(id).orElse(null);
    }

    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {

    }


}
