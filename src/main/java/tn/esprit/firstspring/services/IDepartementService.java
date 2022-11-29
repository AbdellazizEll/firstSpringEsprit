package tn.esprit.firstspring.services;

import tn.esprit.firstspring.entities.Departement;
import tn.esprit.firstspring.entities.Equipe;
import tn.esprit.firstspring.entities.Option;

import java.util.List;

public interface IDepartementService {
    public List<Departement> getAllDepartements();
    public Departement addDepartement(Departement d);
    public Departement updateDepartement(Departement d);
    public void deleteDepartement(int id);
    public Departement getDepartementById(int id );

    List<Departement> retrieveDepartementByOptionEtudiant( Option op);
}
