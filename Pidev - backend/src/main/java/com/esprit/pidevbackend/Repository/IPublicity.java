package com.esprit.pidevbackend.Repository;

import com.esprit.pidevbackend.Domain.Publicity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface IPublicity extends JpaRepository<Publicity, Long> {
    Optional<Publicity> findByOffersIdOffer(Long id);
    List<Publicity> findAllByOffersTitle(String title);
    List<Publicity> findAllByOffersStarDate(Date starDate);
    List<Publicity> findAllByOffersCollaborationRate(String rate);
    List<Publicity> findAllByOffersDescrption(String description);
    List<Publicity> findAllByOffers(String rate);

}
