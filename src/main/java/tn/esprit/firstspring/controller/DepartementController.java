package tn.esprit.firstspring.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstspring.entities.Departement;
import tn.esprit.firstspring.entities.Option;
import tn.esprit.firstspring.services.IDepartementService;
import java.util.List;
@AllArgsConstructor
@RestController
public class DepartementController {

    IDepartementService iDepartementService;

    @GetMapping("/getAllDepartements")
    public List<Departement> getAllDepartements(){
        return iDepartementService.getAllDepartements();


    }
    @PostMapping("/addDepartement")
    @ResponseBody
    public Departement addDepartement(@RequestBody Departement d) {
        return iDepartementService.addDepartement(d);
    }
    @PutMapping("/updateDepartement")
    @ResponseBody
    public Departement updateDepartement( @RequestBody Departement d) {
        return iDepartementService.updateDepartement(d);
    }
    @DeleteMapping("/deleteDepartemenet/{id}")
    public void deleteDepartement( @PathVariable("id") int id) {
        iDepartementService.deleteDepartement(id);

    }
    @GetMapping("/getDepartementById/{id}")
    public Departement getDepartementById( @PathVariable("id") int id) {
        return iDepartementService.getDepartementById(id);

    }
    @GetMapping("/getDepartementByOptionEtudiant/{op}")
    public List<Departement> retrieveDepartementByOptionEtudiant(@PathVariable("op") Option op ) {
        return  iDepartementService.retrieveDepartementByOptionEtudiant(op);

    }

}

