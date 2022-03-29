package com.esprit.pidevbackend.Web;

import com.esprit.pidevbackend.Domain.Offer;
import com.esprit.pidevbackend.Service.ICollaborationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Offer")
@AllArgsConstructor
public class OfferController {


    private ICollaborationService offerService;

    //http://localhost:8085/addOffer
    @PostMapping("/addOffer/{idCollaboration}")
    @ResponseBody
    public void addOffer(@RequestBody Offer o, @PathVariable long idCollaboration){
        offerService.addOffer(o,idCollaboration);
    }

    //http://localhost:8085/deleteOffer/id
    @DeleteMapping("/deleteOffer/{id}")
    @ResponseBody
    public void deleteOffer(@PathVariable Long id){
        offerService.deleteOffer(id);
    }

    //http://localhost:8080/Offer/updateOffer
    @PutMapping("/updateOffer")
    @ResponseBody
    public Offer updateOffer(@RequestBody Offer o){
        return offerService.updateOffer(o);
    }

    //http://localhost:8085/Offer/retrieveAllOffers
    @GetMapping("/retrieveAllOffers")
    @ResponseBody
    public List<Offer> retrieveAllOffers(){
        return offerService.retrieveAllOffers();
    }

    //http://localhost:8085/Offer/retrieveAllOffers/id
    @GetMapping("/retrieveOffer/{id}")
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




