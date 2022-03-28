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
import tn.esprit.spring.entities.PublicationFil;
import tn.esprit.spring.services.ICommentService;
import tn.esprit.spring.services.IHistoryService;

@RestController
@RequestMapping("/Comment")
public class CommentRestController {
	
	@Autowired
	ICommentService commentService;
	
	
	
	 @PostMapping("/addCm")
	 public CommentFil addCm (@RequestBody CommentFil cm) {
		 return commentService.addCm(cm);
		 
	 }
	 @GetMapping("/GetAllCm")
	    public List<CommentFil> getcomments(){
	    	return commentService.getcomments();
	    }
	    @GetMapping("/getCm/{idc}")
	    public Optional<CommentFil> finPubById(@PathVariable ("idc") Long idc){
	    	return commentService.finPubById(idc);
	    }
	    @DeleteMapping("/DelCm/{idc}")
	    public void DeleteCm (@PathVariable("idc") Long idc) {
	    	commentService.DeleteCm(idc);
	    }
	    @PutMapping("/UpdaCm")
	    public CommentFil UpdatPub (@RequestBody CommentFil cm) {
	    	return commentService.UpdatPub(cm);
	    }
	
	
	  

}
