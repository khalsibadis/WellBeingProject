package com.esprit.pidevbackend.Repository;

import com.esprit.pidevbackend.Domain.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface IOffer extends JpaRepository<Offer, Long> {

     Optional<Offer> findByIdOffer(int id);
     List<Offer> findAllByLocalisation(String localisation);
     List<Offer> findAllByStarDate(Date starDate);
     List<Offer> findAllByDescrption(String description);
    List<Offer> findAllByCollaborationRate(String rate);
}
