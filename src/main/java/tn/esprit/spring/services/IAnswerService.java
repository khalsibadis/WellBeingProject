package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;
import tn.esprit.spring.entities.AnswerQuiz;
import tn.esprit.spring.entities.QuestionQuiz;


public interface IAnswerService {
	
	public AnswerQuiz addAns (AnswerQuiz ans);
    public List<AnswerQuiz> getAnswers();
    public Optional<AnswerQuiz> finAnswerById(Long idA);
    public void DeleteAns (Long idA);
    public AnswerQuiz UpdateAns (AnswerQuiz ans);
    
    void delete(AnswerQuiz answer) ;

	List<AnswerQuiz> findAnswersByQuestion(QuestionQuiz question);

	int countAnswersInQuestion(QuestionQuiz question);

}
