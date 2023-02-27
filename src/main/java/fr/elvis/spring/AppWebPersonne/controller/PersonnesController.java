package fr.elvis.spring.AppWebPersonne.controller;

import fr.elvis.spring.AppWebPersonne.entities.Personnes;
import fr.elvis.spring.AppWebPersonne.service.PersonnesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class PersonnesController {


    @Autowired
    private PersonnesService personnesServices;


    // pour recuperer l'ensemble des personnes
    @RequestMapping("/personnes")
    public List<Personnes> GetPersonne(){
        return personnesServices.getPersonnes();
    }

    // pour recuperer une personne par son ID
    @RequestMapping("/personne/{id}")
    public Optional<Personnes> GetPersonne(@PathVariable long id){
        return personnesServices.getPersonne(id);
    }

    // supprimer une personne
    @RequestMapping(method = RequestMethod.DELETE, value = "/personne/{id}")
    public void deletePersonne (@PathVariable long id) {
        personnesServices.deletePersonnne(id); ;
    }


    // ajouter une personne
    @RequestMapping(method = RequestMethod.POST , value = "/personnes")
    public void addPersonne (@RequestBody Personnes personnes) {
        personnesServices.addpersonne(personnes);
    }

    // mise à jour d'une personne
    @RequestMapping(method = RequestMethod.PUT, value = "/personne/{id}")
    public void updateCar(@RequestBody Personnes personnes,@PathVariable long id) {
        personnesServices.updatePersonne(personnes,id);
    }
}
