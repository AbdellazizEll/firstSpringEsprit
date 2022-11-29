package tn.esprit.firstspring.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstspring.entities.Equipe;
import tn.esprit.firstspring.entities.Niveau;
import tn.esprit.firstspring.services.IEquipeService;

import java.util.List;

@RestController
@AllArgsConstructor

public class EquipeController {

    IEquipeService iEquipeService;


    @GetMapping("/getAllEquipes")
    public List<Equipe> getAllEquipes(){
        return iEquipeService.getAllEquipes();
    }
    @PostMapping("/addEquipe")
    @ResponseBody
    public Equipe addEquipe(@RequestBody Equipe e) {
        return iEquipeService.addEquipe(e);
    }
    @PutMapping("/updateEquipe")
    @ResponseBody
    public Equipe updateEquipe( @RequestBody Equipe e) {
        return iEquipeService.updateEquipe(e);
    }
    @DeleteMapping("/deleteEquipe/{id}")
    public void deleteEquipe( @PathVariable("id") int id) {
        iEquipeService.deleteEquipe(id);

    }
    @GetMapping("/getEquipeById/{id}")
    public Equipe getEquipeById( @PathVariable("id") int id) {
        return iEquipeService.getEquipeById(id);

    }


    @GetMapping("/findEtudientIdetudient/{idEtudiant}")
     public List<Equipe> findByEtudiantIdEtudiant( @PathVariable("idEtudiant") int idEtudiant)
     {
         return iEquipeService.findByEtudiantIdEtudiant(idEtudiant);
 }
    @GetMapping("/getEtudiantanddetailEquipe/{idEtudiant}")
    public List<Equipe> getEtudiantIdEtudiantAndDetailEquipeThematiqueNotNull(  @PathVariable("idEtudiant")   Integer idEtudiant) {
        return iEquipeService.findByEtudiantIdEtudiantAndDetailEquipeThematiqueNotNull(idEtudiant);
    }
    @GetMapping("/getEtudiantByDepartement/{idEtudiant}/{idDepart}")
    public List<Equipe> getEtudiantByDepartement(  @PathVariable("idEtudiant")   Integer idEtudiant,  @PathVariable("idDepart") Integer idDepart) {
        return iEquipeService.findByEtudiantIdEtudiantAndEtudiantDepartementIdDepart(idEtudiant,idDepart);
    }

    @GetMapping("/retriveEquipeByNiveauAndThematique/{niveau}/{thematique}")
    public List<Equipe> retriveEquipeByNiveauAndThematique(@PathVariable("niveau") Niveau niveau ,@PathVariable("thematique")
    String thematique) {
        return iEquipeService.retriveEquipeByNiveauAndThematique(niveau,thematique);
    }

    @PostMapping("/addEquipeAndDetailEquipe")
    @ResponseBody
    public Equipe addEquipeAndDetailEquipe(@RequestBody Equipe e) {
        return iEquipeService.addEquipeAvecDetail(e);
    }
}

