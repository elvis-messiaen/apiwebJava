package fr.elvis.spring.AppWebPersonne.service;

import fr.elvis.spring.AppWebPersonne.entities.Personnes;
import fr.elvis.spring.AppWebPersonne.repository.Personnesrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonnesService {
    @Autowired
    private Personnesrepository personnesrepository;


    public List<Personnes> getPersonnes(){
        List<Personnes> personnes = new ArrayList<>();
        personnesrepository.findAll().forEach(personnes::add);
        return personnes;
    }

    public Optional<Personnes> getPersonne(long id) {
        return personnesrepository.findById(id);
    }

    public void deletePersonnne(long id) {
        personnesrepository.deleteById(id);
    }

    public void addpersonne(Personnes personnes) {
        personnesrepository.save(personnes);
    }

    public void updatePersonne(Personnes personnes,long id) {
        personnesrepository.save(personnes);
    }
}
