package com.WellBeingProject.GetCloser.Repository;

import com.WellBeingProject.GetCloser.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {
}
