package com.WellBeingProject.GetCloser.Service;

import com.WellBeingProject.GetCloser.Entity.CommentPub;
import com.WellBeingProject.GetCloser.Repository.CommentPubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentPubServiceImpl implements ICommentPubService {
    @Autowired
    CommentPubRepository commentPubRepository;
    @Override
    public void AddCommentPub(CommentPub e) {
        commentPubRepository.save(e);
    }

    @Override
    public List<CommentPub> getAllCommentPub() {
        return  commentPubRepository.findAll();
    }

    @Override
    public void DeleteCommentPub(int id) {
         commentPubRepository.deleteById(id);
    }

    @Override
    public void UpdateCommentPub(CommentPub e) {
        commentPubRepository.save(e);
    }
}
