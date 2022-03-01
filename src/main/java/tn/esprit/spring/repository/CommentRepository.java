package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Comment;


public interface CommentRepository extends CrudRepository<Comment, Integer> {

}
