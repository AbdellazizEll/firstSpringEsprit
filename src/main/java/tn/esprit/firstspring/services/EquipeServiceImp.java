package tn.esprit.firstspring.services;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.firstspring.entities.*;
import tn.esprit.firstspring.repository.ContratRepository;
import tn.esprit.firstspring.repository.DetailEquipeRepository;
import tn.esprit.firstspring.repository.EquipeRepository;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor

public class EquipeServiceImp implements IEquipeService {



    EquipeRepository equipeRepository;
    DetailEquipeRepository detailEquipeRepository;

    ContratRepository contratRepository;
    @Override
    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public void deleteEquipe(int id) {
        equipeRepository.deleteById(id);
    }

    @Override
    public Equipe getEquipeById(int id) {
        return equipeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Equipe> findByEtudiantIdEtudiant(int idEtudiant) {
        return equipeRepository.findByEtudiantIdEtudiant(idEtudiant);
    }

    @Override
    public List<Equipe> findByEtudiantIdEtudiantAndDetailEquipeThematiqueNotNull(int idEtudiant) {
        return equipeRepository.findByEtudiantIdEtudiantAndDetailEquipeThematiqueNotNull(idEtudiant);
    }
    @Override
    public List<Equipe> findByEtudiantIdEtudiantAndEtudiantDepartementIdDepart(Integer idEtudiant, Integer idDepart) {
        return equipeRepository.findByEtudiantIdEtudiantAndEtudiantDepartementIdDepart(idEtudiant,idDepart);
    }

    @Override
    public List<Equipe> retriveEquipeByNiveauAndThematique(Niveau niveau, String thematique) {
        return equipeRepository.retriveEquipeByNiveauAndThematique(niveau, thematique);
    }

    @Override
    public Equipe addEquipeAvecDetail(Equipe e) {
        DetailEquipe de = e.getDetailEquipe();
        detailEquipeRepository.save(de);
        return equipeRepository.save(e);
    }


    @Override
    @Scheduled(fixedRate = 60000)
    public void faireEvoluerEquipes() {
        List<Equipe> equipes = equipeRepository.findAll();
        List<Contrat> contratDepasseAn = contratRepository.contratDepasseAn();
        // contrat depasse un an
        int cValid = 0;
        // etudiant d'une equipe ayant contrat valid
        int eValid = 0;
        for (Equipe e : equipes){
            if (e.getEtudiant().size()>=3 ){
                for(Etudiant etudiant : e.getEtudiant()){
                    Set<Contrat> lc = etudiant.getContrat();
                    for (Contrat contrat : lc){
                        if (contratDepasseAn.contains(contrat)){
                            cValid += cValid +1;
                            eValid++;
                        }
                    }

                }


            }

            if (eValid>=3&& e.getNiveau()==Niveau.JUNIOR) {
                e.setNiveau(Niveau.SENIOR);
                equipeRepository.save(e);
            } else if (cValid>=3&& (e.getNiveau()==Niveau.SENIOR)) {
                e.setNiveau(Niveau.EXPERT);
                equipeRepository.save(e);
            }
        }



    }




}
