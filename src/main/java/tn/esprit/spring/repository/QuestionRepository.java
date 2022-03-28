package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.History;
import tn.esprit.spring.entities.QuestionQuiz;
@Repository
public interface QuestionRepository extends JpaRepository<QuestionQuiz, Long>{

}
