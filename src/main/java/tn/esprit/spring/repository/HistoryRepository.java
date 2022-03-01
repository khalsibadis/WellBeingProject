package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import tn.esprit.spring.entities.History;

public interface HistoryRepository extends CrudRepository<History, Integer>{

}
