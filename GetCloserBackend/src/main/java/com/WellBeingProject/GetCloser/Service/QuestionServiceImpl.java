package com.WellBeingProject.GetCloser.Service;

import com.WellBeingProject.GetCloser.Entity.Question;
import com.WellBeingProject.GetCloser.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements IQuestionService {
    @Autowired
    QuestionRepository  questionRepository;
    @Override
    public void AddQuestion(Question e) {
    questionRepository.save(e);
    }

    @Override
    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public void DeleteQuestion(int id) {
    questionRepository.deleteById(id);
    }

    @Override
    public void UpdateQuestion(Question e) {
    questionRepository.save(e);
    }
}
