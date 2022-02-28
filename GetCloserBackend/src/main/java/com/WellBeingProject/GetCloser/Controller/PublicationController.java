package com.WellBeingProject.GetCloser.Controller;

import com.WellBeingProject.GetCloser.Entity.Publication;
import com.WellBeingProject.GetCloser.Service.IPublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Publication")
public class PublicationController {
    @Autowired
    IPublicationService iPublicationService;

    @PostMapping("/Add")
    public void AddPublication(Publication e) {
        iPublicationService.AddPublication(e);
    }
    @GetMapping("/Get")
    public List<Publication> getAllPublication() {
        return  iPublicationService.getAllPublication();
    }
    @PutMapping("/Put")
    public void UpdatePublication(@RequestBody Publication e) {
        iPublicationService.UpdatePublication(e);
    }

    @DeleteMapping("Delete/{id}")
    public void DeletePublication(@PathVariable("id") int id) {
        iPublicationService.DeletePublication(id);
    }


}
