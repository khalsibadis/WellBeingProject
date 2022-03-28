package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;



import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.AnswerQuiz;
import tn.esprit.spring.entities.History;
import tn.esprit.spring.entities.Phase;
import tn.esprit.spring.entities.User;

import tn.esprit.spring.entities.QuestionQuiz;
import tn.esprit.spring.entities.Quiz;
import tn.esprit.spring.repository.HistoryRepository;
import tn.esprit.spring.repository.PhaseRepository;
import tn.esprit.spring.repository.UtilisaRepository;
import tn.esprit.spring.repository.QuestionRepository;

@Slf4j
@Service
public class QuestionServiceImpl implements IQuestionService {
	
	
	@Autowired
	QuestionRepository questionRepository;
	
	@Autowired
    PhaseRepository levelRepository;

	@Override
	public QuestionQuiz addQuestion(QuestionQuiz qt) {
		
		return questionRepository.save(qt);
	}

	@Override
	public List<QuestionQuiz> getQuestions() {
		
		return questionRepository.findAll() ;
	}

	@Override
	public Optional<QuestionQuiz> finQuestById(Long idq) {
		
		return questionRepository.findById(idq);
	}

	@Override
	public void DeleteQt(Long idq) {
		questionRepository.deleteById(idq);
		
	}

	@Override
	public void UpdateQt(QuestionQuiz qt) {
		questionRepository.save(qt);
		
	}

	@Override
	public Boolean checkIsCorrectAnswer(QuestionQuiz question, Long answer_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCorrectAnswer(QuestionQuiz question, AnswerQuiz answer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AnswerQuiz getCorrectAnswer(QuestionQuiz question) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AnswerQuiz addAnswerToQuestion(AnswerQuiz answer, QuestionQuiz question) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countQuestionsInQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countValidQuestionsInQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Long findAnswerIdCorrect(Long idq) {
		QuestionQuiz questionq=questionRepository.findById(idq).get();
		for(AnswerQuiz answerq:questionq.getAnswers()) {
			if(answerq.isIscorrect()) {
				return answerq.getIdA();
			}
				
		}
		return (long) -1;
	
	}

	////////////////////////
	
	 

	

		


	
	
	

	
	
	
}
