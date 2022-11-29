package tn.esprit.firstspring.services;

import tn.esprit.firstspring.entities.DetailEquipe;

import java.util.List;

public interface IDetailEquipeService {
    public List<DetailEquipe> getAllDetailEquipes();
    public DetailEquipe addDetailEquipe(DetailEquipe de);
    public DetailEquipe updateDetailEquipe(DetailEquipe de);
    public void deleteDetailEquipe(int id);
    public DetailEquipe getDetailEquipeById(int id );
     public List<DetailEquipe> findByThematiqueLike (String thematique);
}
