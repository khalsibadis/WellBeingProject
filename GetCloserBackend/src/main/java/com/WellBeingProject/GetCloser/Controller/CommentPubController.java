package com.WellBeingProject.GetCloser.Controller;

import com.WellBeingProject.GetCloser.Entity.CommentPub;
import com.WellBeingProject.GetCloser.Service.ICommentPubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("commentPub")
public class CommentPubController {
    @Autowired
    ICommentPubService iCommentPubService;
    @PostMapping("/Add")
    public void AddCommentPub(@RequestBody CommentPub e) {
        iCommentPubService.AddCommentPub(e);
    }
    @GetMapping("/Get")
    public List<CommentPub> getAllCommentPub() {
        return iCommentPubService.getAllCommentPub();
    }
    @PutMapping("/Put")
    public void UpdateCommentPub(@RequestBody CommentPub e) {
       iCommentPubService.UpdateCommentPub(e);
    }
    @DeleteMapping("/Delete/{id}")
    public void DeleteCommentPub(@PathVariable("id") int id) {
        iCommentPubService.DeleteCommentPub(id);
    }


}
