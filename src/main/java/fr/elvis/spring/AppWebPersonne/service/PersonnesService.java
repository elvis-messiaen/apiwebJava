package fr.elvis.spring.AppWebPersonne.service;

import fr.elvis.spring.AppWebPersonne.entities.Personnes;
import fr.elvis.spring.AppWebPersonne.repository.Personnesrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonnesService {
    @Autowired
    private Personnesrepository personnesrepository;

    // pour recuperer l'ensemble des personnes
    public List<Personnes> getPersonnes(){
        List<Personnes> personnes = new ArrayList<>();
        List<Personnes> listeTrier = new ArrayList<>();
        listeTrier.sort((Comparator<? super Personnes>) personnes);
        personnesrepository.findAll().forEach(listeTrier::add);
        return personnes;
    }

    // pour recuperer une personne par son ID
    public Optional<Personnes> getPersonne(long id) {
        return personnesrepository.findById(id);
    }

    // supprimer une personne
    public void deletePersonnne(long id) {
        personnesrepository.deleteById(id);
    }

    //attention seule les personnes de moins de 150 ans peuvent être enregistrées sinon renvoyer une erreur
    // ajouter une personne
    public void addpersonne(Personnes personnes) {
        Calendar dateDuJour = Calendar.getInstance();
        int annee = dateDuJour.get(Calendar.YEAR);
        if (annee <150){
            personnesrepository.save(personnes);
        }
        else{
            System.out.println("L'age doirt être inférieur à 150 ans");
        }

    }

    // mise à jour d'une personne
    public void updatePersonne(Personnes personnes,long id) {
        personnesrepository.save(personnes);
    }
}
