package com.esprit.pidevbackend.Web;


import com.esprit.pidevbackend.Domain.Answer;

import com.esprit.pidevbackend.Service.IAnswerService;
import com.esprit.pidevbackend.Service.IPdfService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Answer")

public class AnswerController {
    @Autowired
    IAnswerService iAnswerService ;
    @Autowired
    IPdfService iPdfService ;

    //@Secured({"ROLE_ADMIN"})

    @PostMapping("/Add")
    public void AddAnswer(@RequestBody Answer e) {
        iAnswerService.AddAnswer(e);
    }

    //@Secured({"ROLE_ADMIN"})
    @PutMapping("/Put")
    public void UpdateAnswer(@RequestBody Answer e) {
        iAnswerService.UpdateAnswer(e);
    }

    //@Secured({"ROLE_ADMIN"})
    @GetMapping("/Get")
    public List<Answer> getAllAnswer() {
        return iAnswerService.getAllAnswer();
    }

    //@Secured({"ROLE_ADMIN"})

    @DeleteMapping("/Delete/{id}")
    public void DeleteAnswer(@PathVariable("id") Long id) {
       iAnswerService.DeleteAnswer(id);
    }
    //@Secured({"ROLE_ADMIN"})

    @PostMapping("/AddAnswerToQuestion/{idQ}")
    public void AddAnswerToQuestion(@RequestBody Answer e, @PathVariable("idQ") Long idQ) {
    iAnswerService.AddAnswerToQuestion(e,idQ);
    }
    //@Secured({"ROLE_USER","ROLE_ADMIN"})

    @PutMapping("/AddAnswerToUser/{idU}/{idA}")
    public void AddAnswerToUser(@PathVariable("idU") Long idUser, @PathVariable("idA") Long idAnswer) {
        iAnswerService.AddAnswerToUser(idUser, idAnswer);
    }
    //@Secured({"ROLE_USER","ROLE_ADMIN"})

    @GetMapping("/getPDF/{idu}/{idQvt}")
    public String toPDF(@PathVariable("idu") Long idUser, @PathVariable("idQvt") Long idQvt){

        return iPdfService.toPDF(idUser, idQvt);
    }

}
