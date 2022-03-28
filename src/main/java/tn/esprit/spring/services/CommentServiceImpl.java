package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.CommentFil;
import tn.esprit.spring.repository.CommentRepository;
import tn.esprit.spring.repository.HistoryRepository;

@Slf4j
@Service
public class CommentServiceImpl implements ICommentService {
	@Autowired
	CommentRepository commentRepository;

	@Override
	public CommentFil addCm(CommentFil cm) {
		
		return commentRepository.save(cm);
	}

	@Override
	public List<CommentFil> getcomments() {
	
		return commentRepository.findAll();
	}

	@Override
	public Optional<CommentFil> finPubById(Long idc) {
		
		return commentRepository.findById(idc);
	}

	@Override
	public void DeleteCm(Long idc) {
		commentRepository.deleteById(idc);
		
	}

	@Override
	public CommentFil UpdatPub(CommentFil cm) {
		
		return commentRepository.save(cm);
	}

	

}
