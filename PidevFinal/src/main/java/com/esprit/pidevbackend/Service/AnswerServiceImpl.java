package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.Answer;
import com.esprit.pidevbackend.Domain.Question;
import com.esprit.pidevbackend.Domain.User;
import com.esprit.pidevbackend.Repository.AnswerRepository;
import com.esprit.pidevbackend.Repository.QuestionRepository;
import com.esprit.pidevbackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class AnswerServiceImpl implements IAnswerService {
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    UserRepository accountRepo;
    @Autowired
    QuestionRepository questionRepository;
    @Override
    public void AddAnswer(Answer e) {
    answerRepository.save(e);
    }

    @Override
    public List<Answer> getAllAnswer() {
        return answerRepository.findAll();
    }

    @Override
    public void DeleteAnswer(Long id) {
    answerRepository.deleteById(id);
    }

    @Override
    public void UpdateAnswer(Answer e) {
    answerRepository.save(e);
    }

    @Override
    @Transactional
    public void AddAnswerToUser(Long idUser, Long idAnswer) {
        User u =accountRepo.findById(idUser).orElse(null);
        Answer a =answerRepository.findById(idAnswer).orElse(null);
        a.getUsers().add(u);
    }

    @Override
    public void AddAnswerToQuestion( Answer e,Long idQuestion) {
        Question q =questionRepository.findById(idQuestion).orElse(null);
        answerRepository.save(e);
        e.setQuestion(q);
    }

    @Override
    public List<Answer> findAllAnswerForQuestion(Long idQue) {
        return answerRepository.findAllAnswerForQuestion(idQue);
    }
    public List<Answer> findAllAnswerByUser(Long idUser) {


        return answerRepository.findAllAnswerByUser(idUser);
    }

}
