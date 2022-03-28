package tn.esprit.spring.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Quiz;


@Repository
public interface QuizRepository  extends JpaRepository<Quiz, Long> {

	Page<Quiz> findByIsPublishedTrue(Pageable pageable);

}
