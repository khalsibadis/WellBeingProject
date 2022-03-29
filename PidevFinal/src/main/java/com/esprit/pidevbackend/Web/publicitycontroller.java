package com.esprit.pidevbackend.Web;

import com.esprit.pidevbackend.API.UploadImage;
import com.esprit.pidevbackend.Domain.Publicity;
import com.esprit.pidevbackend.Service.CollaborationService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Publicity")
@AllArgsConstructor
public class publicitycontroller {

    private CollaborationService publicityService;


    private UploadImage uploadImage;

    @Secured({"ROLE_ADMIN"})
    //http://localhost:8085/addPublicity/1
    @PostMapping("/addPublicity/{idOffer}")
    @ResponseBody
    public void addPublicity(@RequestBody Publicity p, @PathVariable long idOffer){
        publicityService.addPublicity(p,idOffer);
    }


    @Secured({"ROLE_ADMIN"})
    //http://localhost:8080/Collaboration/deleteCollaboration/id
    @DeleteMapping("/deletePublicity/{id}")
    public void deletePublicity(@PathVariable Long id){
        publicityService.deletePublicity(id);
    }
    @Secured({"ROLE_ADMIN"})
    //http://localhost:8080/Collaboration/updateCollaboration
    @PutMapping("/updatePublicity")
    @ResponseBody
    public Publicity updatePublicity(@RequestBody Publicity p){
        return publicityService.updatePublicity(p);
    }


}

