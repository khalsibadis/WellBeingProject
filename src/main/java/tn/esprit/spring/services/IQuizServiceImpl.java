package tn.esprit.spring.services;




import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Quiz;
import tn.esprit.spring.entities.User;

import tn.esprit.spring.repository.QuizRepository;
@Slf4j
@Service
@Transactional
public class IQuizServiceImpl implements IQuizService {
	
	
	@Autowired 
	QuizRepository quizrepository;

	
	@Override
	public Quiz saveQuiz(Quiz quiz) {
	
		return quizrepository.save(quiz);
	}
	
	
	
	@Override
	public List<Quiz> getAllQuiz() {
		
		return quizrepository.findAll();
	}



	@Override
	public Quiz updateQuiz(Quiz quiz) {
		
		return quizrepository.save(quiz);
	}

	@Override
	public void deleteQuizById(Long idQ) {
		quizrepository.deleteById(idQ);
		
	}


	@Override
	public Optional<Quiz> finQuizById(Long idQ) {
		return quizrepository.findById(idQ);
		
	}



	@Override
	public Quiz save(Quiz quiz, User user) {
     quiz.setCreatedBy(user);
		return quizrepository.save(quiz);
	}



	@Override
	public Page<Quiz> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return quizrepository.findAll(pageable);
	}



	@Override
	public Page<Quiz> findAllPublished(Pageable pageable) {
		// TODO Auto-generated method stub
		 return quizrepository.findByIsPublishedTrue(pageable);
	}
	


	
	


	

}
