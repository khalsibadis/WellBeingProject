package com.esprit.pidevbackend.Service;


import com.esprit.pidevbackend.Domain.Commentaire;

import java.util.List;

public interface CommentaireService {
    public void addComment(Commentaire comment);
    public void deleteComment(Long idComment);
    List<Commentaire> listComment();
    public void addCommentToEventAndAffectToUser(Commentaire commentaire, Long idEvent, Long idUser);
    //  public boolean BlockCommentsWithInsultingWords()  ;
    public List<Commentaire> getAllCommentsBlocked();
    public List<Commentaire> getAllCommentsNotBlocked();
    public void BlockCommentsWithInsultingWords(Commentaire aa) ;

    public int CountComments(Long ideve);
    public int CountCommentsIsBlockedByEvent(Long ideve);

}
