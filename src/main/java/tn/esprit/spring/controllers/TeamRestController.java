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
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.History;
import tn.esprit.spring.entities.Team;
import tn.esprit.spring.services.ITeamService;

@RestController
@RequestMapping("/Team")
public class TeamRestController {
	@Autowired
	ITeamService teamservice;
	
	@PostMapping("/addT")
	public  Team addTeam (@RequestBody Team team) {
		return teamservice.addTeam(team);
	}
	
	@GetMapping("/getAllTea")
    public List<Team> getTeams(){
		return teamservice.getTeams();
	}
	 @GetMapping("/getTea/{idt}")
	public Optional<Team> finTeamById(@PathVariable ("idt") Long idt){
		return teamservice.finTeamById(idt);
		
	}
	 @DeleteMapping("/DelTea/{idt}")
	 public void DeleteTeam (@PathVariable ("idt") Long idt) {
		 teamservice.DeleteTeam(idt);
	 }
	
	@PutMapping("/UpdaTea")
    public Team UpdateTeam (@RequestBody Team team) {
		return teamservice.UpdateTeam(team);
			
	}
	
	

}
