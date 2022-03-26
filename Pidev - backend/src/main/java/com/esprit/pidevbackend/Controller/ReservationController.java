package com.esprit.pidevbackend.Controller;


import com.esprit.pidevbackend.Domain.Offer;
import com.esprit.pidevbackend.Domain.Reservation;
import com.esprit.pidevbackend.Repository.IReservation;
import com.esprit.pidevbackend.ServiceImp.IOfferService;
import com.esprit.pidevbackend.ServiceImp.IReservationService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/Reservation")
@RestController
public class ReservationController {

    @Autowired
    IReservationService reservationService;

    //http://localhost:8085/Reservation/addResevation/1/1
    @PostMapping("/addResevation/{idOffer}/{idUser}")
    @ResponseBody
    public void addOffer( @RequestBody Reservation r,@PathVariable long idUser, @PathVariable long idOffer){
        reservationService.reservation(idUser,idOffer,r);
    }

    //http://localhost:8085/Reservation/calculTotal/1/1
    @GetMapping("/calculTotal/{idOffer}/{idReservation}")
    @ResponseBody
    public float calculTotal( @PathVariable long idReservation, @PathVariable long idOffer){
        return reservationService.prixTotale(idReservation,idOffer);
    }

    @Value("sk_test_51KhM0dLVKNxUp7QKaSYm5RgoKdyz63FcA8J4yGCR5QpO6nrroYsbsITZu5YEcURxo5erVDTmGG25XWAC6cvfqztK00TbzVhB6d")
    String stripeKey;


    @PostMapping("/stripe")
    public Reservation index(@RequestBody Reservation r) throws StripeException {
        Stripe.apiKey= stripeKey;
        Map<String, Object> params = new HashMap<>();
        params.put("name",r.getName());
        params.put("email",r.getEmail());
        Customer customer = Customer.create(params);
        r.setCustomerId(customer.getId());
        return r;
    }


}
