package com.example.EventManage.controller;

import com.example.EventManage.entities.Commentaire;
import com.example.EventManage.services.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {
    @Autowired
    CommentaireService commentaireService;

    @PostMapping("addComment")
    public void addComment(@RequestBody Commentaire comment) {
        commentaireService.addComment(comment);
    }

    @DeleteMapping("deleteComment/{id}")
    public void deleteComment(@PathVariable("id") Long idComment) {
        commentaireService.deleteComment(idComment);
    }

    @GetMapping("ListComment")
    public List<Commentaire> listComment() {
        return commentaireService.listComment();
    }

    @PostMapping("addCommentAndAffect/{idEvent}/{idUser}")
    public void addCommentToEventAndAffectToUser(@RequestBody Commentaire commentaire,@PathVariable("idEvent") Long idEvent,@PathVariable("idUser") Long idUser) {
        commentaireService.addCommentToEventAndAffectToUser(commentaire,idEvent,idUser);
    }

    }
