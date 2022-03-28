package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.CommentFil;


public interface ICommentService {
	
	   
	    
		public CommentFil addCm (CommentFil cm);
	    public List<CommentFil> getcomments();
	    public Optional<CommentFil> finPubById(Long idc);
	    public void DeleteCm (Long idc);
	    public CommentFil UpdatPub (CommentFil cm);

}
