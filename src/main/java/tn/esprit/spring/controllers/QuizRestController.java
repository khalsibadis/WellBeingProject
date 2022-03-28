package tn.esprit.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Quiz;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IQuizService;

@RestController
@RequestMapping("/Quiz")
public class QuizRestController  {
	
	@Autowired
	IQuizService quizservice;
	
	@PostMapping("/addQ")
	public Quiz saveQuiz(@RequestBody Quiz quiz) {
		return quizservice.saveQuiz(quiz);
	}
	@GetMapping("/GetAllQuiz")
	public List<Quiz> getAllQuiz(){
		return quizservice.getAllQuiz();
	}
	@GetMapping("/GetQuiz/{idQ}")
	public Optional<Quiz> finQuizById(@PathVariable("idQ") Long idQ) {
		return quizservice.finQuizById(idQ);
	}
	@PutMapping("/UpQuiz")
	public Quiz updateQuiz(@RequestBody Quiz quiz) {
		return quizservice.updateQuiz(quiz);
	}
	@DeleteMapping("/DelQuiz/{idQ}")
	public void deleteQuizById(@PathVariable("idQ") Long idQ) {
		 quizservice.deleteQuizById(idQ);
	}
	
	@GetMapping("/GetQuizPage")
	@ResponseStatus(HttpStatus.OK)
	public Page<Quiz> findAll(Pageable pageable,
			@RequestParam(required = false, defaultValue = "false") Boolean published) {
		
		if (published) {
			return quizservice.findAllPublished(pageable);
		} else {
			return quizservice.findAll(pageable);
		}
	}

	
	
		
	

	
	
	

}
