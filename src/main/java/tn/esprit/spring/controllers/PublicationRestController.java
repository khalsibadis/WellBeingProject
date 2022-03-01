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
import tn.esprit.spring.entities.Publication;
import tn.esprit.spring.entities.Theme;
import tn.esprit.spring.services.IHistoryService;
import tn.esprit.spring.services.IPublicationService;

@RestController
@RequestMapping("/Publication")
public class PublicationRestController {
	@Autowired
	IPublicationService publicationService;
	
	@PostMapping("/addP")
	public void addPubl (@RequestBody Publication pb) {
		publicationService.addPub(pb);
	}
	
	@GetMapping("/getP")
    public List<Publication> getpubls(){
		return publicationService.getpubs();
	}
	@DeleteMapping("/Delete/{idl}")
    public void DeleteL (@PathVariable("idl") int idp) {
		publicationService.DeletePb(idp);
	}
	 @PutMapping("/UpdaP/{idp}")
	    public void UpdatePub(@PathVariable("idp") int id,@RequestBody Publication  pb ) {
	        publicationService.UpdatePb(id, pb);
	    }
	
	 

}
