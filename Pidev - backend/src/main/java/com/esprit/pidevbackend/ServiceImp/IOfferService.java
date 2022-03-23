package com.esprit.pidevbackend.ServiceImp;

import com.esprit.pidevbackend.Domain.Offer;


import java.util.Date;
import java.util.List;

public interface IOfferService {
    List<Offer> retrieveAllOffers();

    void addOffer(Offer o);

    void deleteOffer(Long id);

    Offer updateOffer(Offer o);

    Offer retrieveOffer(Long id);

    void dateOffer(long idOffer, Date starDate, Date finDate);
    
    float calculProm(long idOffer, float promotion);


}
