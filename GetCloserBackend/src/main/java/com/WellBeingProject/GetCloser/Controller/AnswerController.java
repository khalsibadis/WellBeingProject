package com.WellBeingProject.GetCloser.Controller;

import com.WellBeingProject.GetCloser.Entity.Answer;
import com.WellBeingProject.GetCloser.Service.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Answer")
public class AnswerController {
    @Autowired
    IAnswerService iAnswerService;

    @PostMapping("/Add")
    public void AddAnswer(Answer e) {
        iAnswerService.AddAnswer(e);
    }
    @PutMapping("/Put")
    public void UpdateAnswer(@RequestBody Answer e) {
        iAnswerService.UpdateAnswer(e);
    }
    @GetMapping("/Get")
    public List<Answer> getAllAnswer() {
        return iAnswerService.getAllAnswer();
    }
    @DeleteMapping("/Delete/{id}")
    public void DeleteAnswer(@PathVariable("id") int id) {
       iAnswerService.DeleteAnswer(id);
    }



}
