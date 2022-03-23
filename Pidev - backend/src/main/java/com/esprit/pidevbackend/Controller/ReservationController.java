package com.esprit.pidevbackend.Controller;


import com.esprit.pidevbackend.Domain.Offer;
import com.esprit.pidevbackend.Domain.Reservation;
import com.esprit.pidevbackend.Repository.IReservation;
import com.esprit.pidevbackend.ServiceImp.IOfferService;
import com.esprit.pidevbackend.ServiceImp.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationController {

    @Autowired
    IReservationService reservationService;

    //http://localhost:8080/addOffer
    @PostMapping("/Resevation")
    @ResponseBody

    public void addOffer(@PathVariable long idUser, @PathVariable long idOffer, @RequestBody Reservation r){
        reservationService.reservation(idUser,idOffer,r);
    }
}
