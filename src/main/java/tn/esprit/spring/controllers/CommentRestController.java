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

import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.entities.Publication;
import tn.esprit.spring.services.ICommentService;
import tn.esprit.spring.services.IHistoryService;

@RestController
@RequestMapping("/Comment")
public class CommentRestController {
	
	@Autowired
	ICommentService commentService;
	
	
	
	@PostMapping("/addC")
	public void addPubl (@RequestBody Comment cm) {
		commentService.addCom(cm);
	}
	
	@GetMapping("/getC")
    public List<Comment> getcommentss(){
		return commentService.getcomments();
	}
	@DeleteMapping("/Delete/{idC}")
    public void DeleteL (@PathVariable("idC") int idc) {
		commentService.DeleteCm(idc);
	}
	 @PutMapping("/UpdaP/{idC}")
	    public void UpdateCmn(@PathVariable("idC") int idc,@RequestBody Comment  pb ) {
	        commentService.UpdateCm(idc, pb);
	    }
	
	
	  

}
