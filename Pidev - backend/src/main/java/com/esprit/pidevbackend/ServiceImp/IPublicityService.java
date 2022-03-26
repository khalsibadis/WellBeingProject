package com.esprit.pidevbackend.ServiceImp;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.esprit.pidevbackend.Domain.Publicity;
import org.springframework.web.multipart.MultipartFile;


public interface IPublicityService {
    List<Publicity> retrieveAllPublicitys();

    Publicity addPublicity(Publicity p,long idOffer);

    void deletePublicity(Long id);

    Publicity updatePublicity(Publicity p);

    Publicity retrievePublicity(Long id);

    public boolean dateOffer(long idPublicity, Date starDateOf, Date finDateOf);

    public void saveImage(MultipartFile imageFile,Publicity publicity) throws IOException;
}
