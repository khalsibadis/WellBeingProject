package com.example.EventManage.services;

import com.example.EventManage.entities.Commentaire;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CommentaireService {
    public void addComment(Commentaire comment);
    public void deleteComment(Long idComment);
    List<Commentaire> listComment();
    public void addCommentToEventAndAffectToUser(Commentaire commentaire,Long idEvent,Long idUser);
}
