package com.WellBeingProject.GetCloser.Controller;

import com.WellBeingProject.GetCloser.Entity.QVT;
import com.WellBeingProject.GetCloser.Service.IQVTService;
import com.WellBeingProject.GetCloser.Service.QVTServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("QVT")
public class QVTController {
    @Autowired
    IQVTService iqvtService;

    @PostMapping("/Add")
    public void AddQVT( @RequestBody QVT e) {
        iqvtService.AddQVT(e);
    }
    @GetMapping("/Get")
    public List<QVT> getAllQVT() {
        return iqvtService.getAllQVT();
    }
    @PutMapping("/Put")
    public void UpdateQVT(@RequestBody QVT e) {
        iqvtService.UpdateQVT(e);
    }
    @DeleteMapping("/Delete/{id}")
    public void DeleteQVT(@PathVariable("id") int id) {
        iqvtService.DeleteQVT(id);
    }


}
