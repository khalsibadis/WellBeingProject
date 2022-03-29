package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.CommentPub;
import com.esprit.pidevbackend.Domain.Publication;
import com.esprit.pidevbackend.Domain.User;
import com.esprit.pidevbackend.Repository.CommentPubRepository;
import com.esprit.pidevbackend.Repository.PublicationRepository;
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
public class CommentPubServiceImpl implements ICommentPubService {
    @Autowired
    CommentPubRepository commentPubRepository;
    @Autowired
    UserRepository accountRepo;
    @Autowired
    PublicationRepository publicationRepository;
    @Autowired
    MailService mailService;
    @Override
    public void AddCommentPub(CommentPub e) {
        commentPubRepository.save(e);
    }

    @Override
    public List<CommentPub> getAllCommentPub() {
        return  commentPubRepository.findAll();
    }

    @Override
    public void DeleteCommentPub(Long id) {
         commentPubRepository.deleteById(id);
    }

    @Override
    public void UpdateCommentPub(CommentPub e) {
        commentPubRepository.save(e);
    }

    @Override
    public void AddCommentPubToUser(CommentPub e, Long idUser, Long idPub) {
        commentPubRepository.save(e);
        Publication p=publicationRepository.findById(idPub).orElse(null);
        User a=accountRepo.findById(idUser).orElse(null);
        e.setPublication(p);
        e.setUser(a);
    }

   @Override
   public void BlockCommentsWithInsultingWords(CommentPub aa) {
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
               commentPubRepository.save(aa);

               try {
                   mailService.sendEmailNotifAgent(aa.getUser());
               } catch (MessagingException e) {
                   e.printStackTrace();
               }
           } else
               aa.setIsBlocked(false);
           commentPubRepository.save(aa);

   }

    @Override
    public int CountBedComment(Long idUser) {
        return commentPubRepository.CountCommentBlocked(idUser);
    }
}
