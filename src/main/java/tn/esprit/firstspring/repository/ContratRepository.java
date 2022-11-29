package tn.esprit.firstspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.firstspring.entities.Contrat;

import java.util.Date;
import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat, Integer> {



    @Query("SELECT c FROM Contrat c where c.dateDebutContrat >=? 1 and c.dateFinContrat <=? 2 ")
    List<Contrat> ListContratBetweenToDate(@PathVariable("dateD") Date dateD, @PathVariable("dateF") Date dateF);

    @Query("select c from Contrat c where DATEDIFF(c.dateFinC,c.dateDebutC)>=365")
    List<Contrat> contratDepasseAn();
}
