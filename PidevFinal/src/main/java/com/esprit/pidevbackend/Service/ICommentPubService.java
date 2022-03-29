package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.CommentPub;

import java.util.List;

public interface ICommentPubService {
    public void AddCommentPub(CommentPub e);
    public List<CommentPub> getAllCommentPub();
    public void DeleteCommentPub(Long id);
    public void UpdateCommentPub(CommentPub e);
    public void AddCommentPubToUser(CommentPub e, Long idUser, Long idPub);
    public void BlockCommentsWithInsultingWords(CommentPub e);
    public int CountBedComment(Long idUser);
}
