package com.esprit.pidevbackend.ServiceImp;

import java.util.List;

import com.esprit.pidevbackend.Domain.Publicity;


public interface IPublicityService {
    List<Publicity> retrieveAllPublicitys();

    Publicity addPublicity(Publicity p);

    void deletePublicity(Long id);

    Publicity updatePublicity(Publicity p);

    Publicity retrievePublicity(Long id);
}
