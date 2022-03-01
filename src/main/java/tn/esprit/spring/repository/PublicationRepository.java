package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;


import tn.esprit.spring.entities.Publication;

public interface PublicationRepository extends CrudRepository<Publication, Integer> {

}
