package fr.elvis.spring.AppWebPersonne.repository;


import fr.elvis.spring.AppWebPersonne.entities.Personnes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Personnesrepository extends JpaRepository<Personnes,Long> {
}
