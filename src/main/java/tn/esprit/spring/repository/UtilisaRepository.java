package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.History;
import tn.esprit.spring.entities.User;

public interface UtilisaRepository extends CrudRepository<User, Integer>{

}
