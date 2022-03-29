package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.Publication;

import java.util.List;

public interface IPublicationService {
    public void AddPublication(Publication e);
    public List<Publication> getAllPublication();
    public void DeletePublication(Long id);
    public void UpdatePublication(Publication e);
    public void AddPublicationToUser(Publication e, Long id) ;
    public int countAllPublicationByUser(Long idUser);
    public List<Publication> GetAllPubByUser(Long idUser);
}
