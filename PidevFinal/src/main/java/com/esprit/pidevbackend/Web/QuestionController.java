package com.esprit.pidevbackend.Web;


import com.esprit.pidevbackend.Domain.Question;
import com.esprit.pidevbackend.Service.IQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Question")

public class QuestionController {
@Autowired
IQuestionService iQuestionService;
   // @Secured({"ROLE_ADMIN"})

    @PostMapping("/Add")
    public void AddQuestion( @RequestBody Question e) {
        iQuestionService.AddQuestion(e);
    }
   // @Secured({"ROLE_USER","ROLE_ADMIN"})

    @GetMapping("/Get")
    public List<Question> getAllQuestion() {
        return iQuestionService.getAllQuestion();
    }
   // @Secured({"ROLE_ADMIN"})

    @PutMapping("/Put")
    public void UpdateQuestion(@RequestBody Question e) {
        iQuestionService.UpdateQuestion(e);
    }
   // @Secured({"ROLE_ADMIN"})

    @DeleteMapping("/Delete/{id}")
    public void DeleteQuestion( @PathVariable("id") Long id) {
        iQuestionService.DeleteQuestion(id);
    }
   // @Secured({"ROLE_ADMIN"})

    @PutMapping("/AddQuestionToQuizz/{idQuizz}")
    public void AddQuestionToQuizz(@RequestBody Question e, @PathVariable("idQuizz") Long idQuizz) {
        iQuestionService.AddQuestionToQuizz(e, idQuizz);
    }

}
