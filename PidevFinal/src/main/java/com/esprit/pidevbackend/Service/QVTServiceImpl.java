package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.Note;
import com.esprit.pidevbackend.Domain.QVT;
import com.esprit.pidevbackend.Domain.RQuizz;
import com.esprit.pidevbackend.Domain.TypeAnswer;
import com.esprit.pidevbackend.Repository.QVTRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class QVTServiceImpl implements IQVTService {
    @Autowired
     QVTRepsitory qvtRepsitory;
    @Autowired
     IRQuizzService irQuizzSevice;
    @Override
    public void AddQVT(QVT e) {
        qvtRepsitory.save(e);
        RQuizz z = new RQuizz();
        irQuizzSevice.AddRQuizzToQuizz(z,e.getId());
    }

    @Override
    public List<QVT> getAllQVT() {
        return qvtRepsitory.findAll();
    }

    @Override
    public void DeleteQVT(Long id) {
        qvtRepsitory.deleteById(id);
    }

    @Override
    public void UpdateQVT(QVT e) {
        qvtRepsitory.save(e);
    }

    @Override
    public void ConseilsPersonnalisesQuiz(Long idQuizz) {

        RQuizz rQuizz=irQuizzSevice.SelectRquizz(idQuizz);
        List<Long> a=qvtRepsitory.ListIdAnswerAffecteToUser();
        int BAD = 0;
        int Good = 0;
        int Ex = 0;
        for (Long t :a) {
            List<TypeAnswer> typeAnswers = qvtRepsitory.ListeAnswersQuizz(idQuizz, t);



            for (TypeAnswer type : typeAnswers) {

                if (type == TypeAnswer.BAD) {
                    BAD++;
                } else if (type == TypeAnswer.GOOD) {
                    Good++;
                } else if (type == TypeAnswer.EXCELLENT) {
                    Ex++;
                }
            }
            int total = BAD + Good + Ex;
            if (total == 0) {
                total = 1;
            }
            int PourCentageBAD = (BAD * 100) / total;
            System.out.println(BAD / total);
            int PourCentageGood = (Good * 100) / total;
            int PourCentageEX = (Ex * 100) / total;

            rQuizz.setPourCentageBAD(PourCentageBAD);
            rQuizz.setPourCentageGood(PourCentageGood);
            rQuizz.setPourCentageEx(PourCentageEX);

            String Remarque = "null";
            Note note = Note.C;
            if (PourCentageGood <= PourCentageEX && PourCentageBAD <= PourCentageEX) {
                Remarque = "Résultat remarquables , avec seulement quelques insuffiances mineures";
                note = Note.A;

            } else if (PourCentageBAD <= PourCentageGood && PourCentageGood > PourCentageEX) {
                Remarque = "Résultat Généralement Bon , malgré certaines insuffiances notables";
                note = Note.B;

            } else {
                Remarque = "Un travail supplémentaire considérable est nécessaire";
                note = Note.C;
            }
            rQuizz.setNote(note);
            rQuizz.setRemarque(Remarque);
            rQuizz.setTotalResponse(total);

        }
    }

}
