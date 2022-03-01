package tn.esprit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.Evaluation;
import tn.esprit.entities.Promotion;
import tn.esprit.entities.User;
import tn.esprit.servicesInterfaces.EvaluationService;
import tn.esprit.servicesInterfaces.PromotionService;
import tn.esprit.servicesInterfaces.UserService;


@RestController
@RequestMapping("/Evaluation")
public class EvaluationController {
	@Autowired
	UserService userservice ;
	
	@PostMapping("/Add-user")
	public void AddUser(@RequestBody User user){
		userservice.AddUser(user);
	}
	
	@Autowired
	EvaluationService evaluationservice ;
	@PostMapping("/Add-Evaluation/{IdUser}")
	@ResponseBody
	public void addAndaffectEvaluation (@RequestBody Evaluation evaluation ,@PathVariable Long IdUser ){
		 evaluationservice.addAndaffectEvaluation(evaluation, IdUser);
	}
	
	@PostMapping("/Add-Evaluation")
	public void AddEvaluation(@RequestBody Evaluation e) {

		 evaluationservice.AddEvaluation(e);
	}
	@PostMapping("/update-Evaluation")
	public void updateEvaluation(@RequestBody Evaluation e){
		evaluationservice.updateEvaluation(e);
	}
	@PostMapping("/Delete-Evaluation/{Evaluation-id}")
	public void DeleteEvaluation(@PathVariable("Evaluation-id")Long id){
		evaluationservice.deleteEvaluation(id);
	}
	@GetMapping("/retrieve-Evaluations")
	public List<Evaluation> retrieveAllEvaluations(){
		return evaluationservice.retrieveAllEvaluations();
	}
	@GetMapping("/retrieve-Evaluation/{Evaluation-id}")
	public Evaluation retrieveEvaluation(@PathVariable("Evaluation-id")Long id) {
		return evaluationservice.retrieveEvaluation(id);
	}
	@Autowired
	PromotionService promoservice ;
	
	@PostMapping("/Add-promotion")
	public void AddPromotion(@RequestBody Promotion promotion){
		promoservice.AddPromotion(promotion);
	}
	@PostMapping("/Add-Promotion/{IdUser}")
	@ResponseBody
	public void addAndaffectPromotion (@RequestBody Promotion promotion ,@PathVariable Long IdUser ){
		 promoservice.addAndaffectPromotion(promotion, IdUser);
	}
	@PostMapping("/update-Promotion")
	public void updatePromotion(@RequestBody Promotion promotion){
		promoservice.updatePromotion(promotion);
	}
	@PostMapping("/Delete-Promotion/{Promotion-id}")
	public void DeletePromotion(@PathVariable("Promotion-id")Long id){
		promoservice.DeletePromotion(id);
	}
	
	@GetMapping("/retrieve-Promotion")
	public List<Promotion> retrieveAllPromotions(){
		return promoservice.retrieveAllPromotions();
	}
	@GetMapping("/retrieve-Promotion/{Promotion-id}")
	public Promotion retrievePromotion(@PathVariable("Promotion-id")Long id) {
		return promoservice.retrievePromotion(id);
	}
}
