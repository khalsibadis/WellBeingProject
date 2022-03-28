package tn.esprit.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Phase;
import tn.esprit.spring.services.IPhaseService;
import tn.esprit.spring.services.IQuestionService;
@RestController
@RequestMapping("/Level")
public class LevelRestController {
	
	IPhaseService phaseservice;
	
	@PostMapping("/addPh")
	public Phase addPhase (@RequestBody Phase phase) {
		return phaseservice.addPhase(phase);
	}
	 @GetMapping("/GetAllPh")
    public List<Phase> getphases(){
    	return phaseservice.getphases();
    }
    @GetMapping("/getPh/{idph}")
    public Optional<Phase> finPhaseById(@PathVariable ("idph") Long idph){
    	return phaseservice.finPhaseById(idph);
    }
    @DeleteMapping("/DelPh/{idph}")
    public void DeletePh (@PathVariable Long idph) {
    	 phaseservice.DeletePh(idph);
    }
	@PutMapping("/UpdaPh")
    public Phase UpdatePh (@RequestBody Phase phase) {
		return phaseservice.UpdatePh(phase);
    }
	////////////////////////////
	

}
