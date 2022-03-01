package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.repository.CommentRepository;
import tn.esprit.spring.repository.HistoryRepository;

@Slf4j
@Service
public class CommentServiceImpl implements ICommentService {
	@Autowired
	CommentRepository commentRepository;

	@Override
	public void addCom(Comment cm) {
		commentRepository.save(cm);
		
	}

	@Override
	public List<Comment> getcomments() {
		
		return (List<Comment>) commentRepository.findAll();
	}

	@Override
	public void DeleteCm(int idc) {
		commentRepository.deleteById(idc);
		
	}

	@Override
	public void UpdateCm(int idc, Comment cm) {
		 cm = commentRepository.findById(idc).orElse(null);
	        commentRepository.save(cm);
		
	}
	
	

}
