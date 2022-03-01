package tn.esprit.spring.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;



import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.History;
import tn.esprit.spring.entities.Level;
import tn.esprit.spring.entities.User;

import tn.esprit.spring.entities.Question;

import tn.esprit.spring.repository.HistoryRepository;
import tn.esprit.spring.repository.LevelRepository;
import tn.esprit.spring.repository.UtilisaRepository;
import tn.esprit.spring.repository.QuestionRepository;

@Slf4j
@Service
public class QuestionServiceImpl implements IQuestionService {
	
	
	@Autowired
	QuestionRepository questionRepository;
	
	@Autowired
    LevelRepository levelRepository;

	@Override
	public void addQuestion(Question qt) {
		questionRepository.save(qt);
		
	}

	@Override
	public List<Question> getQuestions() {
		
		return (List<Question>) questionRepository.findAll();
	}

	@Override
	public void DeleteQt(int idq) {
		questionRepository.deleteById(idq);
		
	}

	@Override
	public void UpdateTh(Question qt) {
		questionRepository.save(qt);
		
	}

	
	
	 

	

		


	
	
	

	
	
	
}
