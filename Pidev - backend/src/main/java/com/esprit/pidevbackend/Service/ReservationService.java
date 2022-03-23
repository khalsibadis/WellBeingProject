package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.API.EmailSender;
import com.esprit.pidevbackend.Domain.Offer;
import com.esprit.pidevbackend.Domain.Reservation;
import com.esprit.pidevbackend.Domain.User;
import com.esprit.pidevbackend.Repository.*;
import com.esprit.pidevbackend.ServiceImp.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;


@Service
public class ReservationService implements IReservationService {
	@Autowired
	IOffer OfferRepo;

	@Autowired
	ICollaboration CollaborationRepo;

	@Autowired
	IPublicity PublicityRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	IReservation reservationRepo;

	@Autowired
	private EmailSender emailSender;
	


	@Override
	public Reservation reservation(long idUser, long idOffer, Reservation r) {
		User u = userRepo.findById(idUser).orElse(null);
		Offer o = OfferRepo.findById(idOffer).orElse(null);
		r.setUserRes(u);
		r.setOffersRes(o);
		 reservationRepo.save(r);
		 return r;
	}
	
	
	

}
