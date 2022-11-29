package tn.esprit.firstspring.services;

import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.firstspring.entities.Contrat;


import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface IContratService {
    public List<Contrat> getAllContrats();
    public Contrat addContrat(Contrat c);
    public Contrat updateContrat(Contrat c);
    public void deleteContrat(int id);
    public Contrat getContartById(int id );

    @Transactional
    Contrat affectContratToEtudiant(int idContrat, String nomE, String prenomE);


    public String ListContratBetweenToDate(@PathVariable("dateD") Date dateD, @PathVariable("dateF") Date dateF);

}
