package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.EnumLike;
import com.esprit.pidevbackend.Domain.LikePub;

import java.util.List;

public interface ILikeService {
    public void AddLikePub(LikePub e, Long idUser, Long idPub);
    public List<LikePub> getAllLikePub();
    public void DeleteLikePub(Long id);
    public void UpdateLikePub(LikePub e);
    public List<EnumLike> getAllLikeByPub(Long idPub);
    public List<EnumLike> getAllLikeByUser(Long idUserb);
    public int countAllLikeByPub(Long idPub);
    public List<EnumLike> getAllLikeByPubByUser(Long idUser);
}
