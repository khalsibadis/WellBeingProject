package com.esprit.pidevbackend.Service;
import com.esprit.pidevbackend.Domain.EnumLike;
import com.esprit.pidevbackend.Domain.LikePub;
import com.esprit.pidevbackend.Domain.Publication;
import com.esprit.pidevbackend.Domain.User;
import com.esprit.pidevbackend.Repository.LikePubRepo;
import com.esprit.pidevbackend.Repository.PublicationRepository;
import com.esprit.pidevbackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LikePubServiceImpl implements ILikeService {
    @Autowired
    LikePubRepo likePubRepo;
    @Autowired
    UserRepository accountRepo;
    @Autowired
    PublicationRepository publicationRepository;
    @Override
    public void AddLikePub(LikePub e, Long idUser, Long idPub) {
        likePubRepo.save(e);
        User u=accountRepo.findById(idUser).orElse(null);
        Publication p=publicationRepository.findById(idPub).orElse(null);
        u.setLikePubs(e);
        p.getLikePubs().add(e);

    }

    @Override
    public List<LikePub> getAllLikePub() {
        return likePubRepo.findAll();
    }

    @Override
    public void DeleteLikePub(Long id) {
        likePubRepo.deleteById(id);
    }

    @Override
    public void UpdateLikePub(LikePub e) {
        likePubRepo.save(e);
    }

    @Override
    public List<EnumLike> getAllLikeByPub(Long idPub) {
        return likePubRepo.getAllLikeByPub(idPub);
    }

    @Override
    public List<EnumLike> getAllLikeByUser(Long idUserb) {
        return likePubRepo.getAllLikeByUser(idUserb);
    }

    @Override
    public int countAllLikeByPub(Long idPub) {
        return likePubRepo.countAllLikeByPub(idPub);
    }

    @Override
    public List<EnumLike> getAllLikeByPubByUser(Long idUser) {

        List<EnumLike>e=likePubRepo.getAllLikeByPubByUser(idUser);

       return e;
    }
}
