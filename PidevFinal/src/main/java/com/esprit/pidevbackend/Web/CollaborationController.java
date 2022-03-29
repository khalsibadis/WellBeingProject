package com.esprit.pidevbackend.Web;

import com.esprit.pidevbackend.Domain.Collaboration;
import com.esprit.pidevbackend.Service.ICollaborationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Collaboration")

public class CollaborationController {
    @Autowired
    ICollaborationService collaborationService;

	@Secured({"ROLE_ADMIN"})
	//http://localhost:8085/Collaboration/addCollaboration
	@PostMapping("/addCollaboration/{idUser}")
	public void addCollaboration(@RequestBody Collaboration c, @PathVariable long idUser) throws InterruptedException {
		collaborationService.addCollaboration(c,idUser);
	}

	@Secured({"ROLE_ADMIN"})
	//http://localhost:8080/Collaboration/deleteCollaboration/id
	@DeleteMapping("/Collaboration/deleteCollaboration/{id}")
	public void deleteCollaboration(@PathVariable Long id){
		collaborationService.deleteCollaboration(id);
	}
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	//http://localhost:8080/Collaboration/retrieveAllCollaborations
	@GetMapping("/Collaboration/retrieveAllCollaborations")
	@ResponseBody
	public List<Collaboration> retrieveAllCollaborations() {

		return collaborationService.retrieveAllCollaborations();
	}
	@Secured({"ROLE_ADMIN"})
	//http://localhost:8080/Collaboration/updateCollaboration
	@PutMapping("/Collaboration/updateCollaboration")
	@ResponseBody
	public Collaboration updateCollaboration(@RequestBody Collaboration c){
		return collaborationService.updateCollaboration(c);
	}
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	//http://localhost:8080/Collaboration/retrieveCollaboration
	@GetMapping("/Collaboration/retrieveCollaboration")
	@ResponseBody
	public Collaboration retrieveCollaboration(@PathVariable Long id){
		return collaborationService.retrieveCollaboration(id);
	}
}
