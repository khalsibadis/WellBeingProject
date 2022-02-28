package com.example.EventManage.services;

import com.example.EventManage.entities.Commentaire;
import com.example.EventManage.entities.Event;
import com.example.EventManage.entities.User;
import com.example.EventManage.repositories.CommentaireRepository;
import com.example.EventManage.repositories.EventRepository;
import com.example.EventManage.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        commentaire = commentaireRepository.save(commentaire);
        Event event = eventRepository.findById(idEvent).orElse(null);
        User user = userRepository.findById(idUser).orElse(null);
        commentaire.setEvent(event);
        commentaire.setUser(user);

    }
}
