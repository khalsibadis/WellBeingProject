package tn.esprit.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.AnswerQuiz;
import tn.esprit.spring.services.IAnswerService;

@RestController
@RequestMapping("/Answer")
public class AnswerRestController {

	@Autowired
	IAnswerService answerservice;
	
	@PostMapping("/addAns")
	public  AnswerQuiz addAns (@RequestBody AnswerQuiz answerQuiz) {
		return answerservice.addAns(answerQuiz);
	}
	
	@GetMapping("/getAllAns")
    public List<AnswerQuiz> getTeams(){
		return answerservice.getAnswers();
	}
	 @GetMapping("/getAns/{idA}")
	public Optional<AnswerQuiz> finAnswerById(@PathVariable ("idt") Long idA){
		return answerservice.finAnswerById(idA);
		
	}
	 @DeleteMapping("/DelAns/{idA}")
	 public void DeleteTeam (@PathVariable ("idA") Long idA) {
		 answerservice.DeleteAns(idA);
	 }
	
	@PutMapping("/UpdaAns")
    public AnswerQuiz UpdateAns (@RequestBody AnswerQuiz answerQuiz) {
		return answerservice.UpdateAns(answerQuiz);
			
	}
	
	
  

  
	
}
