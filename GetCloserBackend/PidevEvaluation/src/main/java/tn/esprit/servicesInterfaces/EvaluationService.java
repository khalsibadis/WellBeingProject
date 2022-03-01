package tn.esprit.servicesInterfaces;

import java.util.List;



import tn.esprit.entities.Evaluation;

public interface EvaluationService  {
Evaluation AddEvaluation(Evaluation e) ;
public void  addAndaffectEvaluation(Evaluation e,Long IdUser);
Evaluation updateEvaluation (Evaluation e);
void deleteEvaluation (Long id);
List<Evaluation> retrieveAllEvaluations() ;
Evaluation retrieveEvaluation (Long id);
}
