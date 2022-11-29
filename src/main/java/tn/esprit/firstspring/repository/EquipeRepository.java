package tn.esprit.firstspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.firstspring.entities.Equipe;
import tn.esprit.firstspring.entities.Etudiant;
import tn.esprit.firstspring.entities.Niveau;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe, Integer> {
    List<Equipe> findByEtudiantIdEtudiant(int idEtudiant);

    List<Equipe> findByEtudiantIdEtudiantAndDetailEquipeThematiqueNotNull(int idEtudiant);

    List<Equipe> findByEtudiantIdEtudiantAndEtudiantDepartementIdDepart(Integer idEtudiant, Integer idDepart);


    @Query("SELECT e FROM Equipe e , DetailEquipe  de where  e.detailEquipe.idDetailEquipe = de.idDetailEquipe AND e.niveau=:niveau  AND de.thematique=:thematique")
    List<Equipe> retriveEquipeByNiveauAndThematique(Niveau niveau, String thematique);


}
