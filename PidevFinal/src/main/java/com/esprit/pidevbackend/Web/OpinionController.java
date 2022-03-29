package com.esprit.pidevbackend.Web;


import com.esprit.pidevbackend.Domain.Opinion;
import com.esprit.pidevbackend.Service.IOpinionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Opinion")

public class OpinionController {
@Autowired
     IOpinionService iOpinionService;

    //@Secured({"ROLE_USER","ROLE_ADMIN"})

    @PostMapping("/Add")
    public void AddOpinion(@RequestBody Opinion e) {
        iOpinionService.AddOpinion(e);
    }
    @Secured({"ROLE_USER","ROLE_ADMIN"})

    //@PutMapping("/Put")
    public void UpdateOpinion(@RequestBody Opinion e) {
        iOpinionService.UpdateOpinion(e);
    }
    @Secured({"ROLE_USER","ROLE_ADMIN"})

    @GetMapping("/Get")
    public List<Opinion> getAllOpinions() {
        return iOpinionService.getAllOpinions();
    }
    //@Secured({"ROLE_USER","ROLE_ADMIN"})

    @DeleteMapping("/Delete/{id}")
    public void DeleteOpinion(@PathVariable("id") Long id) {
        iOpinionService.DeleteOpinion(id);
    }
    //@Secured({"ROLE_USER","ROLE_ADMIN"})

    @PostMapping("/AddOpinionToUser/{id}")
    public void AddOpinionToUser(@RequestBody Opinion e, @PathVariable("id") Long idUser) {
        iOpinionService.AddOpinionToUser(e, idUser);
    }

}
