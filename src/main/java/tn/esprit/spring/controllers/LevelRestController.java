package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Level;
import tn.esprit.spring.services.ILevelService;
import tn.esprit.spring.services.IQuestionService;
@RestController
@RequestMapping("/Level")
public class LevelRestController {
	@Autowired
	ILevelService levelService;
	
	
	@PostMapping("/addL")
	public void addL (@RequestBody Level lev) {
		levelService.addL(lev);
	}
	
	@GetMapping("/getL")
    public List<Level> getLevels(){
		return levelService.getLevels();
	}
	@DeleteMapping("/Delete/{idl}")
    public void DeleteL (@PathVariable("idl") int idl) {
		levelService.DeleteL(idl);
	}
	@PutMapping("/Updal")
    public void UpdateL (@RequestBody Level lev) {
		levelService.UpdateL(lev);
	}

}
