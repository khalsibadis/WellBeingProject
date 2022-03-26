package com.esprit.pidevbackend.Controller;

import com.esprit.pidevbackend.Domain.Collaboration;
import com.esprit.pidevbackend.ServiceImp.ICollaborationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Collaboration")
public class CollaborationController {
	@Autowired
	ICollaborationService collaborationService;


	//http://localhost:8085/Collaboration/addCollaboration
	@PostMapping("/addCollaboration/{idUser}")
	public void addCollaboration(@RequestBody Collaboration c,@PathVariable long idUser)
	{
		collaborationService.addCollaboration(c,idUser);
	}

	//http://localhost:8080/Collaboration/deleteCollaboration/id
	@DeleteMapping("/Collaboration/deleteCollaboration/{id}")

	public void deleteCollaboration(@PathVariable Long id){
		collaborationService.deleteCollaboration(id);
	}

	//http://localhost:8080/Collaboration/retrieveAllCollaborations
	@GetMapping("/Collaboration/retrieveAllCollaborations")
	@ResponseBody
	public List<Collaboration> retrieveAllCollaborations() {

		return collaborationService.retrieveAllCollaborations();
	}

	//http://localhost:8080/Collaboration/updateCollaboration
	@PutMapping("/Collaboration/updateCollaboration")
	@ResponseBody
	public Collaboration updateCollaboration(@RequestBody Collaboration c){
		return collaborationService.updateCollaboration(c);
	}

	//http://localhost:8080/Collaboration/retrieveCollaboration
	@GetMapping("/Collaboration/retrieveCollaboration")
	@ResponseBody
	public Collaboration retrieveCollaboration(@PathVariable Long id){
		return collaborationService.retrieveCollaboration(id);
	}
}
