package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;


import tn.esprit.spring.entities.AnswerQuiz;
import tn.esprit.spring.entities.History;
import tn.esprit.spring.entities.Phase;
import tn.esprit.spring.entities.User;

import tn.esprit.spring.entities.QuestionQuiz;
import tn.esprit.spring.entities.Quiz;


public interface IQuestionService {
	
	public QuestionQuiz addQuestion (QuestionQuiz qt);
    public List<QuestionQuiz> getQuestions();
    public Optional<QuestionQuiz> finQuestById(Long idq);
    public void DeleteQt (Long idq);
    public void UpdateQt (QuestionQuiz qt);
    
    public Long findAnswerIdCorrect(Long idq );
    
    Boolean checkIsCorrectAnswer(QuestionQuiz question, Long answer_id);

	void setCorrectAnswer(QuestionQuiz question, AnswerQuiz answer);

	AnswerQuiz getCorrectAnswer(QuestionQuiz question);

	AnswerQuiz addAnswerToQuestion(AnswerQuiz answer, QuestionQuiz question);

	int countQuestionsInQuiz(Quiz quiz);

	int countValidQuestionsInQuiz(Quiz quiz);
    
   
	
    
    

}
