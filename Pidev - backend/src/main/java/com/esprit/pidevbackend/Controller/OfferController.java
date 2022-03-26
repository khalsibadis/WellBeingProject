package com.esprit.pidevbackend.Controller;

import com.esprit.pidevbackend.Domain.Offer;
import com.esprit.pidevbackend.ServiceImp.IOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Offer")
public class OfferController {

    @Autowired
    IOfferService offerService;

    //http://localhost:8080/addOffer
    @PostMapping("/addOffer/{idCollaboration}")
    @ResponseBody
    public void addOffer(@RequestBody Offer o,@PathVariable long idCollaboration){
        offerService.addOffer(o,idCollaboration);
    }

    //http://localhost:8080/deleteOffer/id
    @DeleteMapping("/deleteOffer/{id}")
    @ResponseBody
    public void deleteOffer(@PathVariable Long id){
        offerService.deleteOffer(id);
    }

    //http://localhost:8080/Offer/updateOffer
    @PutMapping("/Offer/updateOffer")
    @ResponseBody
    public Offer updateOffer(@RequestBody Offer o){
        return offerService.updateOffer(o);
    }

    //http://localhost:8080/Offer/retrieveAllOffers
    @GetMapping("/Offer/retrieveAllOffers")
    @ResponseBody
    public List<Offer> retrieveAllOffers(){
        return offerService.retrieveAllOffers();
    }

    //http://localhost:8080/Offer/retrieveAllOffers/id
    @GetMapping("/Offer/retrieveOffer/{id}")
    @ResponseBody
    public Offer retrieveOffer(@PathVariable Long id){
        return offerService.retrieveOffer(id);
    }

    @PostMapping("/calculPromotion/{idOffer}")
    @ResponseBody
    public float calculPromotion (@PathVariable long idOffer){
       return offerService.calculProm(idOffer);
    }


}
