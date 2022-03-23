package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.Happy;
import com.esprit.pidevbackend.Domain.Offer;
import com.esprit.pidevbackend.Repository.ICollaboration;
import com.esprit.pidevbackend.Repository.IOffer;
import com.esprit.pidevbackend.Repository.IPublicity;
import com.esprit.pidevbackend.ServiceImp.IOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OfferService implements IOfferService {
	@Autowired
	IOffer OfferRepo;

	@Autowired
	ICollaboration CollaborationRepo;

	@Autowired
	IPublicity PublicityRepo;


	@Override
	public List<Offer> retrieveAllOffers() {
		List<Offer> offers = (List<Offer>)  OfferRepo.findAll();
		return offers;
	}

	@Override
	public void addOffer(Offer o) {
		 OfferRepo.save(o);
	}

	@Override
	public void deleteOffer(Long id) {
		OfferRepo.deleteById(id);
	}

	@Override
	public Offer updateOffer(Offer o) {
		return OfferRepo.save(o);
	}

	@Override
	public Offer retrieveOffer(Long id) {
		return 	OfferRepo.findById(id).orElse(null);

	}

	@Override
	public void dateOffer(long idOffer, Date starDate, Date finDate) {
		Offer  offer = OfferRepo.findById(idOffer).orElse(null);
		Date date =new Date();
		if(date == starDate) {
			OfferRepo.findById(idOffer).orElse(null);
		}else if (date == finDate){
			OfferRepo.deleteById(idOffer);
		}
	}

	
	
	public Optional<Offer> findByIdOffer(int id) {
		return OfferRepo.findByIdOffer(id);
	}
	public List<Offer> findAllByLocalisation(String localisation) {
		return (List<Offer>)  OfferRepo.findAllByLocalisation(localisation);
	}

	List<Offer> findAllByStarDate(Date starDate){
		return (List<Offer>) OfferRepo.findAllByStarDate(starDate);
	}
	List<Offer> findAllByDescrption(String description){
		return (List<Offer>) OfferRepo.findAllByDescrption(description);
	}
	List<Offer> findAllByCollaborationRate(String rate){
		return (List<Offer>) OfferRepo.findAllByCollaborationRate(rate);
	}

	@Override
	public float calculProm(long idOffer, float promotion) {
		Offer offer = OfferRepo.findById(idOffer).orElse(null);
		Offer o =new Offer();
		Date date = new Date();
		float p=0;
		if(date.equals(Happy.BLACK_FRIDAY)) {
			promotion = (p*50) / 100;
		}else if(date.equals(Happy.HAPPY_DAYS)) {
			promotion = (p*20)/100;
		}else if (date.equals(Happy.HAPPY_HOUR)) {
			promotion = (p*20)/100;
		}else {
		   promotion = (o.getPercentage()/100) * p; 	
		}	
		OfferRepo.save(offer);
		return promotion;
	}
}

