package tn.esprit.firstspring.services;

import org.springframework.data.jpa.repository.Query;
import tn.esprit.firstspring.entities.Equipe;
import tn.esprit.firstspring.entities.Niveau;

import java.util.List;

public interface IEquipeService {
    public List<Equipe> getAllEquipes();
    public Equipe addEquipe(Equipe e);
    public Equipe updateEquipe(Equipe e);
    public void deleteEquipe(int id);
    public Equipe getEquipeById(int id );
    public List<Equipe> findByEtudiantIdEtudiant (int idEtudiant);
     public List<Equipe> findByEtudiantIdEtudiantAndDetailEquipeThematiqueNotNull (int idEtudiant);
    public List<Equipe> findByEtudiantIdEtudiantAndEtudiantDepartementIdDepart (Integer idEtudiant, Integer idDepart);


    List<Equipe> retriveEquipeByNiveauAndThematique(Niveau niveau , String thematique);
    Equipe addEquipeAvecDetail(Equipe e);

    void faireEvoluerEquipes();


}
