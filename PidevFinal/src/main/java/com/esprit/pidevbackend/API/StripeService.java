package com.esprit.pidevbackend.API;

import com.esprit.pidevbackend.Domain.Payment;
import com.esprit.pidevbackend.Domain.Reservation;
import com.esprit.pidevbackend.Domain.User;
import com.esprit.pidevbackend.Repository.IReservation;
import com.esprit.pidevbackend.Repository.UserRepository;
import com.esprit.pidevbackend.Service.CollaborationService;
import com.esprit.pidevbackend.Service.ICollaborationService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

@Service
public class StripeService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    IReservation reservationRepo;
    @Autowired
    CollaborationService collaborationService;
    @Autowired
    ICollaborationService reservationService;

    @Value("sk_test_51KhM0dLVKNxUp7QKaSYm5RgoKdyz63FcA8J4yGCR5QpO6nrroYsbsITZu5YEcURxo5erVDTmGG25XWAC6cvfqztK00TbzVhB6d")
    String stripeKey;

    public Payment payment(long idUser, long idReservation, Payment p) throws StripeException {
        Stripe.apiKey = stripeKey;
        User user = userRepository.findById(idUser).get();
        Reservation reservation = reservationRepo.findById(idReservation).get();
        Map<String, Object> params = new HashMap<>();
        params.put("name", user.getName());
        params.put("email", user.getEmail());
       // params.put("amount", reservation.getPriceTotal());
        //params.put("created",p.getCreated());
        Customer customer = Customer.create(params);
        p.setCustomerId(customer.getId());
        return p;
    }

    public Reservation createCharge(String email, String token, Long idUser, Long idReservation, Long idOffer, Reservation r) throws StripeException, MessagingException {
        User user = userRepository.findById(idUser).get();
        Reservation reservation = reservationRepo.findById(idReservation).get();
        String id;
        Stripe.apiKey = stripeKey;
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", Math.round(reservation.getPriceTotal() * 100));
        chargeParams.put("currency", "usd");
        chargeParams.put("receipt_email", email);
        chargeParams.put("description", "Charge for " + email);
        chargeParams.put("source", token); // ^ obtained with Stripe.js
        //create a charge
        Charge charge = Charge.create(chargeParams);
        id = charge.getId();
        if (id == null) {
            throw new RuntimeException("Something went wrong!");
        }

        // payment successfully
        Reservation reserva = reservationService.reservation(idUser,idOffer,r);
        return reserva ;
    }
}
