package com.esprit.pidevbackend.ServiceImp;

import com.esprit.pidevbackend.Domain.Reservation;

public interface IReservationService {
	
	   Reservation reservation(long idUser, long idOffer, Reservation r);
	   float prixTotale (long idUser,long idReservation);

}
