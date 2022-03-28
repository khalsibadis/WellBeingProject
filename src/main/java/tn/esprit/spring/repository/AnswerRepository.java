package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.AnswerQuiz;

@Repository
public interface AnswerRepository extends JpaRepository<AnswerQuiz, Long> {

}
