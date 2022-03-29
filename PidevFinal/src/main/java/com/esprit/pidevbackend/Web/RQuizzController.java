package com.esprit.pidevbackend.Web;


import com.esprit.pidevbackend.Domain.RQuizz;
import com.esprit.pidevbackend.Service.IRQuizzService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("RQuizz")

public class RQuizzController {
    @Autowired
     IRQuizzService irQuizzSevice;
    //@Secured({"ROLE_ADMIN"})

    @PostMapping("/Post")
    public void AddRQuizz (@RequestBody RQuizz e){
    irQuizzSevice.AddRQuizz(e);
    }
    //@Secured({"ROLE_USER","ROLE_ADMIN"})

    @GetMapping("/Get")
    @ResponseBody
    public List<RQuizz> getAllRQuizz(){
        return irQuizzSevice.getAllRQuizz();
    }

    //@Secured({"ROLE_ADMIN"})

    @DeleteMapping("Delete/{id}")
    public void DeleteRQuizz (@PathVariable("id") Long id){
        irQuizzSevice.DeleteRQuizz(id);
    }
    //@Secured({"ROLE_ADMIN"})

    @PutMapping("Put")
    public void UpdateRQuizz (@RequestBody RQuizz e){
        irQuizzSevice.UpdateRQuizz(e);
    }
}
