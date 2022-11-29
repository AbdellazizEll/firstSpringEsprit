package tn.esprit.firstspring.services;


import tn.esprit.firstspring.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    public List<Universite> getAllUniversites();
    public Universite addUniversite(Universite u);
    public Universite updateUniversite(Universite u);
    public void deleteUniversite(int id);
    public Universite getUniversiteById(int id );
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);
}
