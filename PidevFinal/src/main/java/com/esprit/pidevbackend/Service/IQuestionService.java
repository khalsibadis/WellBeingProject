package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.Question;

import java.util.List;

public interface IQuestionService {
    public void AddQuestion(Question e);
    public List<Question> getAllQuestion();
    public void DeleteQuestion(Long id);
    public void UpdateQuestion(Question e);
    public void AddQuestionToQuizz(Question e, Long idQuizz);
    public List<Question> findAllQuestionByQVT(Long idQVT);
}
