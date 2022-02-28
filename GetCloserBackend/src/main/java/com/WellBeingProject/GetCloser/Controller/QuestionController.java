package com.WellBeingProject.GetCloser.Controller;

import com.WellBeingProject.GetCloser.Entity.Question;
import com.WellBeingProject.GetCloser.Service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Question")
public class QuestionController {
    @Autowired
    IQuestionService iQuestionService;

    @PostMapping("/Add")
    public void AddQuestion(Question e) {
        iQuestionService.AddQuestion(e);
    }
    @GetMapping("/Get")
    public List<Question> getAllQuestion() {
        return iQuestionService.getAllQuestion();
    }
    @PutMapping("/Put")
    public void UpdateQuestion(@RequestBody Question e) {
        iQuestionService.UpdateQuestion(e);
    }
    @DeleteMapping("/Delete/{id}")
    public void DeleteQuestion( @PathVariable("id") int id) {
        iQuestionService.DeleteQuestion(id);
    }

}
