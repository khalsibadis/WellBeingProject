package com.esprit.pidevbackend.Web;

import com.esprit.pidevbackend.Domain.CommentPub;
import com.esprit.pidevbackend.Service.ICommentPubService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commentPub")

public class CommentPubController {
    @Autowired
    ICommentPubService iCommentPubService ;

    //@Secured({"ROLE_USER","ROLE_ADMIN"})

    @PostMapping("/Add")
    public void AddCommentPub(@RequestBody CommentPub e) {
        iCommentPubService.AddCommentPub(e);
       // iCommentPubService.BlockCommentsWithInsultingWords(e);
    }
   // @Secured({"ROLE_USER","ROLE_ADMIN"})

    @GetMapping("/Get")
    public List<CommentPub> getAllCommentPub() {
        return iCommentPubService.getAllCommentPub();
    }
    //@Secured({"ROLE_USER","ROLE_ADMIN"})

    @PutMapping("/Put")
    public void UpdateCommentPub(@RequestBody CommentPub e) {
       iCommentPubService.UpdateCommentPub(e);
    }
    //@Secured({"ROLE_USER","ROLE_ADMIN"})

    @DeleteMapping("/Delete/{id}")
    public void DeleteCommentPub(@PathVariable("id") Long id) {
        iCommentPubService.DeleteCommentPub(id);
    }

   // @Secured({"ROLE_USER","ROLE_ADMIN"})

    @PostMapping("/addCommentToPubAndUser/{idU}/{idP}")
    public void AddCommentPubToUser(@RequestBody CommentPub e, @PathVariable("idU") Long idUser, @PathVariable("idP") Long idPub){
        iCommentPubService.AddCommentPubToUser(e,idUser,idPub);
        iCommentPubService.BlockCommentsWithInsultingWords(e);
    }

}
