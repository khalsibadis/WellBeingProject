package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import tn.esprit.spring.entities.Quiz;
import tn.esprit.spring.entities.User;



public interface IQuizService {
	
	
	public Quiz saveQuiz(Quiz quiz);
	public List<Quiz> getAllQuiz();
	public Optional<Quiz> finQuizById(Long idQ);
	public Quiz updateQuiz(Quiz quiz);
	public void deleteQuizById(Long idQ);
	
	public Quiz save(Quiz quiz, User user);
	public Page<Quiz> findAll(Pageable pageable);
	
	public Page<Quiz> findAllPublished(Pageable pageable);
	
	
	



}
