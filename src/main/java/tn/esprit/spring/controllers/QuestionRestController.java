package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Level;
import tn.esprit.spring.entities.Question;
import tn.esprit.spring.services.ILevelService;
import tn.esprit.spring.services.IQuestionService;

@RestController
@RequestMapping("/Question")
public class QuestionRestController {
	
	@Autowired
	IQuestionService questionService;
	
	@PostMapping("/addQ")
	public void addedQuestion (@RequestBody Question qt) {
		questionService.addQuestion(qt);
	}
	
	@GetMapping("/getQ")
    public List<Question> getQues(){
		return questionService.getQuestions();
	}
	@DeleteMapping("/Delete/{idq}")
    public void DeleteQtt (@PathVariable("idq") int idq) {
		questionService.DeleteQt(idq);
	}
	@PutMapping("/Updaq")
    public void UpdateL (@RequestBody Question qt) {
		questionService.UpdateTh(qt);
	}
	
	

}
