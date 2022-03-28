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


import tn.esprit.spring.entities.PublicationFil;

import tn.esprit.spring.services.IPublicationService;

@RestController
@RequestMapping("/Publication")
public class PublicationRestController {
	@Autowired
	IPublicationService publicationService;
	
	
	

	@PostMapping("/addP")
	public PublicationFil addPub (@RequestBody PublicationFil pb) {
		return publicationService.addPub(pb);
	}
	 @GetMapping("/GetAllPub")
    public List<PublicationFil> getpubs(){
    	return publicationService.getpubs();
    }
	 @GetMapping("/getPub/{idp}")
    public Optional<PublicationFil> finPubById(@PathVariable ("idp")   Long idp){
    	return publicationService.finPubById(idp);
    }
	 @DeleteMapping("/DelPub/{idp}")
    public void DeletePub (@PathVariable ("idp")  Long idp) {
    	 publicationService.DeletePub(idp);
    }
	 @PutMapping("/UpdaPub")
    public PublicationFil UpdatPub (@RequestBody PublicationFil pb) {
    	return publicationService.UpdatPub(pb);
    }
    

	

  
  

	
	 

}
