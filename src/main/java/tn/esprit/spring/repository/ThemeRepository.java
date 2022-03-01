package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Theme;


public interface ThemeRepository  extends CrudRepository<Theme, Integer> {

}
