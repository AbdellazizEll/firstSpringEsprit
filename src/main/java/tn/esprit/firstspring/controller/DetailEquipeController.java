package tn.esprit.firstspring.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstspring.entities.DetailEquipe;
import tn.esprit.firstspring.services.IDetailEquipeService;

import java.util.List;

@RestController
@AllArgsConstructor

public class  DetailEquipeController {

    IDetailEquipeService iDetailEquipeService;


    @GetMapping("/getAllDetailEquipes")
    public List<DetailEquipe> getAllDetailEquipes(){
        return iDetailEquipeService.getAllDetailEquipes();


    }
    @PostMapping("/addDetailEquipe")
    @ResponseBody
    public DetailEquipe addDetailEquipe(@RequestBody DetailEquipe e) {
        return iDetailEquipeService.addDetailEquipe(e);
    }
    @PutMapping("/updateDetailEquipe")
    @ResponseBody
    public DetailEquipe updateDetailEquipe( @RequestBody DetailEquipe e) {
        return iDetailEquipeService.updateDetailEquipe(e);
    }
    @DeleteMapping("/deleteDetailEquipe/{id}")
    public void deleteDetailEquipe( @PathVariable("id") int id) {
        iDetailEquipeService.deleteDetailEquipe(id);

    }
    @GetMapping("/getDetailEquipeById/{id}")
    public DetailEquipe getDetailEquipeById( @PathVariable("id") int id) {
        return iDetailEquipeService.getDetailEquipeById(id);

    }
    @GetMapping("/getDetailEquipeByThematique/{thematique}")
    public List<DetailEquipe> getDetailEquipeByThematiqueLike (@PathVariable("thematique") String thematique){
        return iDetailEquipeService.findByThematiqueLike(thematique);
    }

}
