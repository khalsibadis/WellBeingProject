package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.entities.Publication;

public interface ICommentService {
	
	    public void addCom(Comment cm);
	    public List<Comment> getcomments();
	    public void DeleteCm (int idc);
	    public void UpdateCm (int idc ,Comment pb);

}
