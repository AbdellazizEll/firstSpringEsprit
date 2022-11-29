package tn.esprit.firstspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.firstspring.entities.Departement;
import tn.esprit.firstspring.entities.Equipe;
import tn.esprit.firstspring.entities.Etudiant;
import tn.esprit.firstspring.entities.Option;

import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {

    @Query(" SELECT d FROM Departement d, Etudiant e where d.idDepart = e.departement.idDepart AND  e.opt =: op ")
    List<Departement> retrieveDepartementByOptionEtudiant( Option op);
}
