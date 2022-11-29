package tn.esprit.firstspring.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.firstspring.entities.Contrat;
import tn.esprit.firstspring.entities.Departement;
import tn.esprit.firstspring.entities.Equipe;
import tn.esprit.firstspring.entities.Etudiant;
import tn.esprit.firstspring.repository.ContratRepository;
import tn.esprit.firstspring.repository.DepartementRepository;
import tn.esprit.firstspring.repository.EquipeRepository;
import tn.esprit.firstspring.repository.EtudiantRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
// @Primary  utilise cette implementation en 1
public class EtudiantServiceImp implements IEtudiantService {


      // @Autowired
      EtudiantRepository etudiantRepository;
      DepartementRepository departementRepository;
      ContratRepository contratRepository;
      EquipeRepository equipeRepository;

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {

        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public void deleteEtudiant(int id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public Etudiant getEtudiantById(int id) {

        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public Etudiant findEtudiantByPrenomE(String prenomE) {
        return etudiantRepository.findEtudiantByPrenomE(prenomE);
    }

    @Override
    public void assignEtudiantToDepartement(int etudiantId, int departementId) {
        Etudiant e = etudiantRepository.findById(etudiantId).orElse(null);
        Departement d = departementRepository.findById(departementId).orElse(null);
        e.setDepartement(d);
        etudiantRepository.save(e);
    }

    @Override
    @Transactional // le tout ou rien
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {
        Contrat contrat = contratRepository.findById(idContrat).orElse(null);
        Equipe equipe= equipeRepository.findById(idEquipe).orElse(null);
                contrat.setEtudiant(e);
                equipe.getEtudiant().add(e);
        return e;
    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(int idDepartement) {
        return  etudiantRepository.findEtudiantByDepartement_IdDepart(idDepartement);

    }





}
