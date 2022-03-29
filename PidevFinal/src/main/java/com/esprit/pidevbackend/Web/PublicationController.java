package com.esprit.pidevbackend.Web;


import com.esprit.pidevbackend.Domain.Publication;
import com.esprit.pidevbackend.Service.IPublicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Publication")

public class PublicationController {
@Autowired
    IPublicationService iPublicationService;
   // @Secured({"ROLE_USER","ROLE_ADMIN"})

    @PostMapping("/Add")
    public void AddPublication(@RequestBody Publication e) {
        iPublicationService.AddPublication(e);
    }
   // @Secured({"ROLE_USER","ROLE_ADMIN"})

    @GetMapping("/Get")
    public List<Publication> getAllPublication() {
        return  iPublicationService.getAllPublication();
    }
   // @Secured({"ROLE_USER","ROLE_ADMIN"})

    @PutMapping("/Put")
    public void UpdatePublication(@RequestBody Publication e) {
        iPublicationService.UpdatePublication(e);
    }
   // @Secured({"ROLE_USER","ROLE_ADMIN"})

    @DeleteMapping("Delete/{id}")
    public void DeletePublication(@PathVariable("id") Long id) {
        iPublicationService.DeletePublication(id);
    }
   // @Secured({"ROLE_USER","ROLE_ADMIN"})

    @PostMapping("AddPubToUser/{idu}")
    public void AddPublicationToUser(@RequestBody Publication e, @PathVariable("idu") Long id){
        iPublicationService.AddPublicationToUser(e,id);
    }


}
