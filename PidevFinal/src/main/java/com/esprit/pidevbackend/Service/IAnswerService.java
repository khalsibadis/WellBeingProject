package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.Answer;

import java.util.List;

public interface IAnswerService {
    public void AddAnswer(Answer e);
    public List<Answer> getAllAnswer();
    public void DeleteAnswer(Long id);
    public void UpdateAnswer(Answer e);
    public void AddAnswerToUser(Long idUser, Long idAnswer);
    public void AddAnswerToQuestion(Answer e, Long idQuestion);
    public List<Answer> findAllAnswerForQuestion(Long idQue);
    public List<Answer> findAllAnswerByUser(Long idUser) ;

}
