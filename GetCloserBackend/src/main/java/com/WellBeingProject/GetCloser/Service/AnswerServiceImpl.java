package com.WellBeingProject.GetCloser.Service;

import com.WellBeingProject.GetCloser.Entity.Answer;
import com.WellBeingProject.GetCloser.Repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements IAnswerService {
    @Autowired
    AnswerRepository answerRepository;
    @Override
    public void AddAnswer(Answer e) {
    answerRepository.save(e);
    }

    @Override
    public List<Answer> getAllAnswer() {
        return answerRepository.findAll();
    }

    @Override
    public void DeleteAnswer(int id) {
    answerRepository.deleteById(id);
    }

    @Override
    public void UpdateAnswer(Answer e) {
    answerRepository.save(e);
    }
}
