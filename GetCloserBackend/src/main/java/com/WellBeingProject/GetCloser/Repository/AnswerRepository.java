package com.WellBeingProject.GetCloser.Repository;


import com.WellBeingProject.GetCloser.Entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Integer> {
}
