package tn.esprit.firstspring.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.firstspring.entities.Contrat;
import tn.esprit.firstspring.entities.Etudiant;
import tn.esprit.firstspring.repository.ContratRepository;
import tn.esprit.firstspring.repository.EtudiantRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ContratServiceImp implements IContratService {


    ContratRepository contratRepository;
    EtudiantRepository etudiantRepository;

    @Override
    public List<Contrat> getAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat addContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public Contrat updateContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public void deleteContrat(int id) {
         contratRepository.deleteById(id);

    }

    @Override
    public Contrat getContartById(int id) {
        return contratRepository.findById(id).orElse(null);
    }



    @Override
    @Transactional
    public Contrat affectContratToEtudiant(int idContrat, String nomE, String prenomE) {


        Etudiant etudiant = etudiantRepository.findEtudiantByNomEAndPrenomE(nomE, prenomE);
        Contrat ce = contratRepository.findById(idContrat).orElse(null);

        Set<Contrat> contrats = etudiant.getContrat();

        Integer nbContratssActifs = 0;

        if (contrats.size() != 0) {
            for (Contrat contrat : contrats) {
                if (((contrat.getArchive()) != null && ((contrat.getArchive() != false)))) {
                    nbContratssActifs++;
                }
            }

        }
        if (nbContratssActifs <= 4) {
            ce.setEtudiant(etudiant);
            contratRepository.save(ce);

        }
        return ce;


    }

    @Override
    public String ListContratBetweenToDate(Date dateD, Date dateF) {

        float chiffre=0;
        float chiffreIA=0;
        float chiffreRESAUX=0;
        float chiffreCLOUD=0;
        float chiffreSECURITE=0;
        List<Contrat> lc = contratRepository.ListContratBetweenToDate(dateD,dateF);
        for(Contrat c : lc){

            if(c.getSpecialite().toString().equals("IA")){
                chiffreIA = chiffreIA + c.getMontantContrat();
                System.out.println("******** Ia ="+chiffreIA);
            }
            if(c.getSpecialite().toString().equals("CLOUD")){
                chiffreCLOUD = chiffreCLOUD + c.getMontantContrat();
                System.out.println("******** Ia ="+chiffreIA);
            }
            if(c.getSpecialite().toString().equals("SECURITE")){
                chiffreCLOUD = chiffreCLOUD + c.getMontantContrat();
                System.out.println("******** Ia ="+chiffreIA);
            }
            if(c.getSpecialite().toString().equals("RESEAUX")){
                chiffreRESAUX = chiffreRESAUX + c.getMontantContrat();
                System.out.println("******** Ia ="+chiffreIA);
            }
            chiffre = chiffre + c.getMontantContrat();

        }
        String ch ="Pour un contrat dont la spécialité est IA: "+chiffreIA+"Dt/mois\n" +
                "Pour un contrat dont la spécialité est RESEAUX: "+chiffreRESAUX+"Dt/mois\n" +
                "Pour un contrat dont la spécialité est CLOUD: "+chiffreCLOUD+"Dt/mois\n" +
                "Pour un contrat dont la spécialité est SECURITE: "+chiffreSECURITE+"Dt/mois\n";
        return ch;
    }

}


