package tn.esprit.firstspring.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstspring.entities.Etudiant;
import tn.esprit.firstspring.services.IEtudiantService;

import java.util.List;

@RestController
@AllArgsConstructor
//   @qualifier("imp1)  ken tabda andi 2  implementation l service  nakhtar eli bech nekhdem behaaa
public class EtudiantController {

    IEtudiantService iEtudiantService;

    @GetMapping
    public String SayHello() {
        return "Hello";
    }

    @GetMapping("/getAllEtudiants")
    public List<Etudiant> getAllEtudiants() {
        return iEtudiantService.getAllEtudiants();


    }

    @PostMapping("/addEtudiant")
    @ResponseBody
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        return iEtudiantService.addEtudiant(e);
    }

    @PutMapping("/updateEtudiant")
    @ResponseBody
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {
        return iEtudiantService.updateEtudiant(e);
    }

    @DeleteMapping("/deleteEtudiant/{id}")
    public void deleteEtudiant(@PathVariable("id") int id) {
        iEtudiantService.deleteEtudiant(id);

    }

    @GetMapping("/getEtudiantById/{id}")
    public Etudiant getEtudiantById(@PathVariable("id") int id) {
        return iEtudiantService.getEtudiantById(id);

    }

    @GetMapping("/getEtudiantByPrenom/{prenom}")
    public Etudiant getEtudiantByprenomF(@PathVariable("prenom") String prenom) {
        return iEtudiantService.findEtudiantByPrenomE(prenom);

    }

    @PutMapping("/assignEtudiantToDepartement/{idE}/{idD}")
    public void assignEtudiantToDepartement(@PathVariable("idE") int idE, @PathVariable("idD") int idD) {
        iEtudiantService.assignEtudiantToDepartement(idE, idD);

    }

    @PostMapping("/assignEtudiantToDepartement/{idContrat}/{idEquipe}")
    public void addAndAssignEtudiantToEquipeAndContrat(
            @RequestBody Etudiant e,
            @PathVariable("idContrat") int idContrat, @PathVariable("idEquipe") int idEquipe) {
        iEtudiantService.addAndAssignEtudiantToEquipeAndContract(e, idContrat, idEquipe);

    }

    @GetMapping("/getEtudiantsByDepartement/{idDepartement}")
    public List<Etudiant> getEtudiantsByDepartement(@PathVariable("idDepartement") int idDepartement) {
        return iEtudiantService.getEtudiantsByDepartement(idDepartement);


    }


}

