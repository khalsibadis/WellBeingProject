package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.Publication;
import com.esprit.pidevbackend.Domain.User;
import com.esprit.pidevbackend.Repository.PublicationRepository;
import com.esprit.pidevbackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PublicationServiceImpl implements IPublicationService {
    @Autowired
    PublicationRepository publicationRepository;
    @Autowired
    UserRepository accountRepo;
    @Override
    public void AddPublication(Publication e) {
       publicationRepository.save(e);
    }

    @Override
    public List<Publication> getAllPublication() {
        return  publicationRepository.findAll();
    }

    @Override
    public void DeletePublication(Long id) {
        publicationRepository.deleteById(id);
    }

    @Override
    public void UpdatePublication(Publication e) {
        publicationRepository.save(e);
    }

    @Override
    public void AddPublicationToUser(Publication e, Long id) {
        User account=accountRepo.findById(id).orElse(null);
        publicationRepository.save(e);
        e.setUser(account);
    }

    @Override
    public int countAllPublicationByUser(Long idUser) {
        return publicationRepository.countAllPublicationByUser(idUser);
    }

    @Override
    public List<Publication> GetAllPubByUser(Long idUser) {
        return GetAllPubByUser(idUser);
    }


}
