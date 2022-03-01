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


import tn.esprit.spring.entities.History;
import tn.esprit.spring.entities.Level;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.entities.Question;
import tn.esprit.spring.entities.Theme;
import tn.esprit.spring.services.IQuestionService;
import tn.esprit.spring.services.IThemeService;

@RestController
@RequestMapping("/Theme")
public class ThemeRestController {
	@Autowired
	IQuestionService questionService;
	
	@Autowired
	IThemeService themeService;
	
	 @PostMapping("/addT")
	 public void addTheme (@RequestBody Theme th) {
		  themeService.addTheme(th);
	 }
	
	
	 @GetMapping("/getT")
	 public List<Theme> getThemess() {
		 return themeService.getThemes();
	 }
	 
	 @DeleteMapping("/Delete/{idt}")
	    public void DeleteThe(@PathVariable("idt") int id) {
	        themeService.DeleteTh(id);
	    }
	 
	 @PutMapping("/UpdaT/{idtt}")
	    public void UpdateTheme(@PathVariable("idtt") int id,@RequestBody Theme th ) {
	        themeService.UpdateTh(id, th);
	    }
	
	    
	  
}
