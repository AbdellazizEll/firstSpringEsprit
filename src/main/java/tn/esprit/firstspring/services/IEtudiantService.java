package tn.esprit.firstspring.services;

import tn.esprit.firstspring.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {

    public List<Etudiant> getAllEtudiants();
    public Etudiant addEtudiant(Etudiant e);
    public Etudiant updateEtudiant(Etudiant e);
    public void deleteEtudiant(int id);
    public Etudiant getEtudiantById(int id );
    public Etudiant findEtudiantByPrenomE(String prenomE);

    public void assignEtudiantToDepartement (int etudiantId, int departementId) ;
    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe);

    List<Etudiant> getEtudiantsByDepartement (int idDepartement);
}
