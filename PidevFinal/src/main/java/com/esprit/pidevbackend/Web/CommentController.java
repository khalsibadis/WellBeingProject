package com.esprit.pidevbackend.Web;

import com.esprit.pidevbackend.Domain.*;
import com.esprit.pidevbackend.Service.CommentaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comment")

public class CommentController {
    @Autowired
    CommentaireService commentaireService;

 //   @Secured({"ROLE_USER","ROLE_ADMIN"})

    @PostMapping("addComment")
    public void addComment(@RequestBody Commentaire comment) {
        commentaireService.addComment(comment);
    }

    //@Secured({"ROLE_USER","ROLE_ADMIN"})

    @DeleteMapping("deleteComment/{id}")
    public void deleteComment(@PathVariable("id") Long idComment) {
        commentaireService.deleteComment(idComment);
    }

  //  @Secured({"ROLE_USER","ROLE_ADMIN"})

    @GetMapping("ListComment")
    public List<Commentaire> listComment() {
        return commentaireService.listComment();
    }

//    @Secured({"ROLE_USER","ROLE_ADMIN"})

    @PostMapping("addCommentAndAffect/{idEvent}/{idUser}")
    public void addCommentToEventAndAffectToUser(@RequestBody Commentaire commentaire, @PathVariable("idEvent") Long idEvent, @PathVariable("idUser") Long idUser) {
        commentaireService.addCommentToEventAndAffectToUser(commentaire, idEvent, idUser);
        commentaireService.BlockCommentsWithInsultingWords(commentaire);
    }



    @GetMapping("retrieveAllBlockedComments")
    public List<Commentaire> getAllCommentsBlocked(){
        return commentaireService.getAllCommentsBlocked();
    }

    @GetMapping("retrieveAllComments")
    public List<Commentaire> getAllCommentsNotBlocked(){
        return commentaireService.getAllCommentsNotBlocked();
    }



}
