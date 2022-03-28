package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.AnswerQuiz;
import tn.esprit.spring.entities.QuestionQuiz;
import tn.esprit.spring.repository.AnswerRepository;

@Slf4j
@Service
@Transactional
public class IAnswerServiceImpl implements IAnswerService {
	
	@Autowired 
	AnswerRepository answerrepository ;

	@Override
	public AnswerQuiz addAns(AnswerQuiz ans) {
		return answerrepository.save(ans);
	}

	@Override
	public List<AnswerQuiz> getAnswers() {
		return answerrepository.findAll();
	}

	@Override
	public Optional<AnswerQuiz> finAnswerById(Long idA) {
		return answerrepository.findById(idA);
	}

	@Override
	public void DeleteAns(Long idA) {
		answerrepository.deleteById(idA);
		
	}

	@Override
	public AnswerQuiz UpdateAns(AnswerQuiz ans) {
		return answerrepository.save(ans);
	
		
	}
///////////////////////////

	@Override
	public void delete(AnswerQuiz answer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AnswerQuiz> findAnswersByQuestion(QuestionQuiz question) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countAnswersInQuestion(QuestionQuiz question) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
