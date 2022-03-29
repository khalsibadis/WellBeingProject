package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.Opinion;
import com.esprit.pidevbackend.Domain.User;
import com.esprit.pidevbackend.Repository.OpinionRepository;
import com.esprit.pidevbackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OpinionServiceImpl implements IOpinionService {
    @Autowired
    OpinionRepository opinionRepository;
    @Autowired
    UserRepository accountRepo;


    @Override
    public void AddOpinion(Opinion e) {
        BlockOpinionsWithInsultingWords(e);
        opinionRepository.save(e);
    }

    @Override
    public List<Opinion> getAllOpinions() {
        List<Opinion> e=  opinionRepository.findAll();
        return e;
    }

    @Override
    public void DeleteOpinion(Long id) {
    opinionRepository.deleteById(id);
    }

    @Override
    public void UpdateOpinion(Opinion e) {
        opinionRepository.save(e);
    }

    @Override
    public void AddOpinionToUser(Opinion e, Long idUser) {
        User a=accountRepo.findById(idUser).orElse(null);
        BlockOpinionsWithInsultingWords(e);
            opinionRepository.save(e);
        e.setUser(a);
    }

    @Autowired
    MailService mailService;

    @Override
    public void BlockOpinionsWithInsultingWords(Opinion aa) {
        List<String> c = new ArrayList<>();
        java.nio.file.Path path = Paths.get("C:\\Users\\aymen\\Desktop\\Full_Bad_Word.txt");
        try {
            for (String line : Files.readAllLines(path)) {
                c.add(line);

            }
            System.out.println("\n");
        } catch (IOException e) {
        }

        if (c.contains(aa.getDescription())) {
            aa.setIsBlocked(true);
            opinionRepository.save(aa);

            try {
                mailService.sendEmailNotifAgent(aa.getUser());
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        } else
            aa.setIsBlocked(false);
        opinionRepository.save(aa);

    }

}
