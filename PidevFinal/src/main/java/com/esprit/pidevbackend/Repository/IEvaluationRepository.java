package com.esprit.pidevbackend.Repository;

import com.esprit.pidevbackend.Domain.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEvaluationRepository extends JpaRepository<Evaluation, Long> {
}
