package tn.esprit.firstspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.firstspring.entities.Universite;

public interface UniversiteRepository extends JpaRepository<Universite, Integer> {
}
