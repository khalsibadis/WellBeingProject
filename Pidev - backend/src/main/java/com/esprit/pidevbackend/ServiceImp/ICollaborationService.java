package com.esprit.pidevbackend.ServiceImp;

import com.esprit.pidevbackend.Domain.Collaboration;


import java.util.List;

public interface ICollaborationService {
    List<Collaboration> retrieveAllCollaborations();

    void addCollaboration(Collaboration c,long idUser);

    void deleteCollaboration(Long id);

    Collaboration updateCollaboration(Collaboration c);

    Collaboration retrieveCollaboration(Long id);

}
