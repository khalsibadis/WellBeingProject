package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.QVT;
import com.esprit.pidevbackend.Domain.Question;
import com.esprit.pidevbackend.Repository.QVTRepsitory;
import com.esprit.pidevbackend.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class QuestionServiceImpl implements IQuestionService {
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    QVTRepsitory qvtRepsitory;
    @Override
    public void AddQuestion(Question e) {
    questionRepository.save(e);
    }

    @Override
    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public void DeleteQuestion(Long id) {
    questionRepository.deleteById(id);
    }

    @Override
    public void UpdateQuestion(Question e) {
    questionRepository.save(e);
    }

    @Override
    public void AddQuestionToQuizz(Question e, Long idQuizz) {
        QVT qvt=qvtRepsitory.findById(idQuizz).orElse(null);
        questionRepository.save(e);
        e.setQvt(qvt);
    }

    @Override
    public List<Question> findAllQuestionByQVT(Long idQVT) {
        return questionRepository.findAllQuestionByQVT(idQVT);
    }


}
