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

import tn.esprit.spring.entities.Phase;
import tn.esprit.spring.entities.QuestionQuiz;
import tn.esprit.spring.services.IPhaseService;
import tn.esprit.spring.services.IQuestionService;

@RestController
@RequestMapping("/Question")
public class QuestionRestController {
	
	@Autowired
	IQuestionService questionService;
	
	
	@PostMapping("/addQue")
	public QuestionQuiz addQuestion (@RequestBody QuestionQuiz qt) {
		return questionService.addQuestion(qt);
	}
	@GetMapping("/GetAllQue")
    public List<QuestionQuiz> getQuestions(){
    	return questionService.getQuestions();
    }
	@GetMapping("/GetQue/{idQue}")
    public Optional<QuestionQuiz> finQuestById(@PathVariable("idQue") Long idq){
    	return questionService.finQuestById(idq);
    }
	@DeleteMapping("/DelQue/{idQue}")
    public void DeleteQt (@PathVariable("idQue") Long idq) {
    	 questionService.DeleteQt(idq);
    }
    @PutMapping("/UpQue")
    public void UpdateQt (@RequestBody QuestionQuiz qt) {
      questionService.UpdateQt(qt);
    }
	
	

}
