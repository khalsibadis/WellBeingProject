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


import tn.esprit.spring.entities.CommentFil;
import tn.esprit.spring.entities.Game;
import tn.esprit.spring.services.IGameService;

@RestController
@RequestMapping("/Game")
public class GameRestController {
	
	@Autowired
	IGameService gameservice;
	
	
	

	@PostMapping("/addG")
	public Game addGame (@RequestBody Game game) {
		return gameservice.addGame(game);
	}
	@GetMapping("/GetAllG")
    public List<Game> getGames(){
		return gameservice.getGames();
	}
	@GetMapping("/getg/{idg}")
	public Optional<Game> findById(@PathVariable ("idg") Long id) {
		return gameservice.finGameById(id);
	}
	@DeleteMapping("/DelG/{idg}")
    public void DeleteG (@PathVariable("idg")  Long idg) {
    	 gameservice.DeleteG(idg);
    }
	@PutMapping("/UpG")
    public Game UpdateG (@RequestBody Game game) {
    	return gameservice.UpdateG(game);
    }
	//////////////////////////
	
	
}
