package tn.esprit.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Evaluation;
import tn.esprit.entities.Promotion;
import tn.esprit.entities.User;
import tn.esprit.repositories.IEvaluationRepository;
import tn.esprit.repositories.IUserRepository;
import tn.esprit.servicesInterfaces.EvaluationService;
@Service
public class EvaluationImpl implements EvaluationService{
@Autowired
IEvaluationRepository EvaluationRepo ;
@Autowired
IUserRepository userRepo ;

	@Override
	public void addAndaffectEvaluation(Evaluation evaluation, Long IdUser) {
	User user = userRepo.findById(IdUser).orElse(null);
	evaluation.setUser(user);
	EvaluationRepo.save(evaluation);
	
		
	}
@Override
public Evaluation AddEvaluation(Evaluation e) {
	
	return EvaluationRepo.save(e);
}
@Override
public Evaluation updateEvaluation(Evaluation e) {
	
	return EvaluationRepo.save(e);
}
@Override
public void deleteEvaluation(Long id) {
	EvaluationRepo.deleteById(id);
	
}
@Override
public List<Evaluation> retrieveAllEvaluations() {
	List<Evaluation> evaluations = (List<Evaluation>) EvaluationRepo.findAll();
	return evaluations;
}
@Override
public Evaluation retrieveEvaluation(Long id) {
	Evaluation e = EvaluationRepo.findById(id).orElse(null);
	return e;
}












	
	

}
