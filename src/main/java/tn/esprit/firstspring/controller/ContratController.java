package tn.esprit.firstspring.controller;


import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstspring.entities.Contrat;

import tn.esprit.firstspring.entities.Etudiant;
import tn.esprit.firstspring.services.IContratService;
;

import java.util.Date;
import java.util.List;
@AllArgsConstructor
@RestController
public class ContratController {



    IContratService iContratService;



    @GetMapping("/getAllContrats")
    public List<Contrat> getAllContrats(){
        return iContratService.getAllContrats();


    }
    @PostMapping("/addContrat")
    @ResponseBody
    public Contrat addContrat(@RequestBody Contrat c) {
        return iContratService.addContrat(c);
    }
    @PutMapping("/updateContrat")
    @ResponseBody
    public Contrat updateContrat( @RequestBody Contrat c) {
        return iContratService.updateContrat(c);
    }
    @DeleteMapping("/deleteContrat/{id}")
    public void deleteContrat( @PathVariable("id") int id) {
        iContratService.deleteContrat(id);

    }
    @GetMapping("/getContratById/{id}")
    public Contrat getContratById( @PathVariable("id") int id) {
        return iContratService.getContartById(id);

    }
    @PostMapping ("/affectContratToEtudiant/{prenomE}/{nomE}")
    public void affectContratToEtudiant(
            @PathVariable int idContrat,
            @PathVariable("prenomE") String prenomE, @PathVariable("nomE")  String nomE ) {
        iContratService.affectContratToEtudiant(idContrat,prenomE,nomE);

    }

    @GetMapping("/getChiffreAffaireEntreDeuxDate")

    public String getChiffreAffaireEntreDeuxDate(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date startDate,
                                                 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("endDate") Date endDate)
    {
        return iContratService.ListContratBetweenToDate(startDate,endDate);
    ;}
}

