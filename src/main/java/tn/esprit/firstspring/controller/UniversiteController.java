package tn.esprit.firstspring.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstspring.entities.Universite;
import tn.esprit.firstspring.services.IUniversiteService;
import java.util.List;

@RestController
@AllArgsConstructor

public class UniversiteController {

    IUniversiteService iUniversiteService;


    @GetMapping("/getAllUniversites")
    public List<Universite> getAllUniversites(){
        return iUniversiteService.getAllUniversites();


    }
    @PostMapping("/addUniversite")
    @ResponseBody
    public Universite addUniversite(@RequestBody Universite e) {
        return iUniversiteService.addUniversite(e);
    }
    @PutMapping("/updateUniversite")
    @ResponseBody
    public Universite updateUniversite( @RequestBody Universite e) {
        return iUniversiteService.updateUniversite(e);
    }
    @DeleteMapping("/deleteUniversite/{id}")
    public void deleteUniversite( @PathVariable("id") int id) {
        iUniversiteService.deleteUniversite(id);

    }
    @GetMapping("/getUniversiteById/{id}")
    public Universite getUniversiteById( @PathVariable("id") int id) {
        return iUniversiteService.getUniversiteById(id);

    }
}

