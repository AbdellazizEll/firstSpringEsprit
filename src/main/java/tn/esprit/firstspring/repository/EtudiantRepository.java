package tn.esprit.firstspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.firstspring.entities.Equipe;
import tn.esprit.firstspring.entities.Etudiant;
import tn.esprit.firstspring.entities.Option;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {
    Etudiant findEtudiantByPrenomE(String prenomE);
    Etudiant findEtudiantByNomEAndPrenomE(String nomE,String prenomE);
    List<Etudiant> findEtudiantByDepartement_IdDepart(int idDepartement);



    @Modifying
    @Query("update Etudiant e set e.idEtudiant =:idEtudiant where e.opt=:op")
    void updateEtudiantByOption(Option op , Long idEtudiant);


    List<Etudiant> getEtudiantByDepartement(int idDepartement);
}
