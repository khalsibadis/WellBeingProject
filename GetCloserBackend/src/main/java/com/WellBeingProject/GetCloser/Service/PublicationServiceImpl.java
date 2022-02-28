package com.WellBeingProject.GetCloser.Service;

import com.WellBeingProject.GetCloser.Entity.Publication;
import com.WellBeingProject.GetCloser.Repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationServiceImpl implements IPublicationService {
    @Autowired
    PublicationRepository publicationRepository;
    @Override
    public void AddPublication(Publication e) {
       publicationRepository.save(e);
    }

    @Override
    public List<Publication> getAllPublication() {
        return  publicationRepository.findAll();
    }

    @Override
    public void DeletePublication(int id) {
        publicationRepository.deleteById(id);
    }

    @Override
    public void UpdatePublication(Publication e) {
        publicationRepository.save(e);
    }
}
