package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.QVT;
import com.esprit.pidevbackend.Domain.RQuizz;
import com.esprit.pidevbackend.Repository.QVTRepsitory;
import com.esprit.pidevbackend.Repository.RQuizzRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RQuizzServiceImpl implements IRQuizzService {
    @Autowired
    RQuizzRepo rQuizzRepo;
    @Autowired
    QVTRepsitory qvtRepsitory;
    @Override
    public void AddRQuizz(RQuizz e) {
        rQuizzRepo.save(e);
    }

    @Override
    public List<RQuizz> getAllRQuizz() {
        return rQuizzRepo.findAll();
    }

    @Override
    public void DeleteRQuizz(Long id) {
        rQuizzRepo.deleteById(id);
    }

    @Override
    public void UpdateRQuizz(RQuizz e) {
        rQuizzRepo.save(e);
    }

    @Override
    public void AddRQuizzToQuizz(RQuizz e, Long idQuizz) {
        QVT qvt= qvtRepsitory.findById(idQuizz).orElse(null);
        rQuizzRepo.save(e);
        qvt.setRQuizzes(e);
    }

    public RQuizz SelectRquizz( Long id){
        return rQuizzRepo.SelectRquizz(id);
    }

}
