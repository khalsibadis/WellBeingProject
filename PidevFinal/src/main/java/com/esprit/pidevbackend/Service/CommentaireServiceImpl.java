package com.esprit.pidevbackend.Service;


import com.esprit.pidevbackend.Domain.Commentaire;
import com.esprit.pidevbackend.Domain.Event;
import com.esprit.pidevbackend.Domain.User;

import com.esprit.pidevbackend.Repository.CommentaireRepository;
import com.esprit.pidevbackend.Repository.EventRepository;
import com.esprit.pidevbackend.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentaireServiceImpl implements CommentaireService {
    @Autowired
    CommentaireRepository commentaireRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public void addComment(Commentaire comment) {
        commentaireRepository.save(comment);

    }

    @Override
    public void deleteComment(Long idComment) {
        commentaireRepository.deleteById(idComment);
    }

    @Override
    public List<Commentaire> listComment() {
        return commentaireRepository.findAll();
    }

    @Transactional
    @Override
    public void addCommentToEventAndAffectToUser(Commentaire commentaire, Long idEvent, Long idUser) {
        commentaire.setDate(new Date());
        commentaire = commentaireRepository.save(commentaire);
        Event event = eventRepository.findById(idEvent).orElse(null);
        User user = userRepository.findById(idUser).orElse(null);
        commentaire.setEvent(event);
        commentaire.setUser(user);

    }
@Transactional
    @Override
    public void BlockCommentsWithInsultingWords(Commentaire aa) {
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
            commentaireRepository.save(aa);
        } else

            aa.setIsBlocked(false);
        commentaireRepository.save(aa);

    }

    @Override
    public List<Commentaire> getAllCommentsBlocked() {
        return commentaireRepository.getAllCommentsBlocked();
    }

    @Override
    public List<Commentaire> getAllCommentsNotBlocked() {
        return commentaireRepository.getAllCommentsNotBlocked();
    }

    @Override
    public int CountComments(Long ideve) {
        return commentaireRepository.CountComments(ideve);
    }
    @Override
    public int CountCommentsIsBlockedByEvent(Long ideve) {
        return commentaireRepository.CountCommentsIsBlocked(ideve);
    }
}
