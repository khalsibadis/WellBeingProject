package tn.esprit.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Evaluation;
@Repository
public interface IEvaluationRepository extends CrudRepository<Evaluation, Long> {

}
