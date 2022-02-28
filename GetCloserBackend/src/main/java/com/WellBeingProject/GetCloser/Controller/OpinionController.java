package com.WellBeingProject.GetCloser.Controller;

import com.WellBeingProject.GetCloser.Entity.Opinion;
import com.WellBeingProject.GetCloser.Service.IOpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Opinion")
public class OpinionController {
    @Autowired
    IOpinionService iOpinionService;

    @PostMapping("/Add")
    public void AddOpinion(@RequestBody Opinion e) {
        iOpinionService.AddOpinion(e);
    }

    @PutMapping("/Put")
    public void UpdateOpinion(@RequestBody Opinion e) {
        iOpinionService.UpdateOpinion(e);
    }
    @GetMapping("/Get")
    public List<Opinion> getAllOpinions() {
        return iOpinionService.getAllOpinions();
    }
    @DeleteMapping("/Delete/{id}")
    public void DeleteOpinion(@PathVariable("id") int id) {
        iOpinionService.DeleteOpinion(id);
    }


}
