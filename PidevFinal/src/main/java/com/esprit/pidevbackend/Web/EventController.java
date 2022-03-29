package com.esprit.pidevbackend.Web;


import com.esprit.pidevbackend.Domain.*;
import com.esprit.pidevbackend.Service.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping("event")
public class EventController {
    @Autowired
    EventService eventService;
   // @Secured({"ROLE_ADMIN"})
    @PostMapping("addEvent")
    public void addEvent(@RequestBody Event event ) {
        eventService.addEvent(event);
    }

  //  @Secured({"ROLE_ADMIN"})

    @DeleteMapping("{id}")
    public void deleteFacture(@PathVariable("id") Long id) {
        eventService.deleteFacture(id);
    }

   // @Secured({"ROLE_USER","ROLE_ADMIN"})

    @GetMapping("listEvent")
    public List<Event> getListEvent() {
        return eventService.getListEvent();
    }

   // @Secured({"ROLE_USER","ROLE_ADMIN"})

    @GetMapping("eventById/{id}")
    @ResponseBody
    public Event getEventById(@PathVariable("id") Long id) {
        return eventService.getEventById(id);
    }

    //@Secured({"ROLE_ADMIN"})

    @PutMapping("ModifierEvent/{id}")
    public void updateEvent(Long id, Event event) {
        eventService.updateEvent(id, event);
    }

    //@Secured({"ROLE_USER","ROLE_ADMIN"})

    @PostMapping("userToEvent/{idUser}/{idEvent}")
    public void addUserToEvent(@PathVariable("idUser") Long idUser, @PathVariable("idEvent") Long idEvent) {
        eventService.addUserToEvent(idUser, idEvent);
    }

    @GetMapping("ListUserByDep/{dep}")
    @ResponseBody
    List<User> afficherListUserByDepartment(@PathVariable("dep") Departement dep) {
        return eventService.afficherListUserByDepartment(dep);
    }
    //@Secured({"ROLE_USER","ROLE_ADMIN"})

    @GetMapping("ListUserByOff/{off}")
    public List<User> afficherListUserByOffice(@PathVariable("off") Office office) {
        return eventService.afficherListUserByOffice(office);
    }
    //@Secured({"ROLE_ADMIN"})

    @PutMapping("updateEvent")
    public void ModifierEvent(Event event) {
        eventService.ModifierEvent(event);
    }
    //@Secured({"ROLE_USER","ROLE_ADMIN"})

    @PostMapping("addEventToFavoris/{idEvent}/{idUser}")
    public void addEventToFavoris(@PathVariable("idEvent") Long idEvent, @PathVariable("idUser") Long idUser) {
        eventService.addEventToFavoris(idEvent, idUser);
    }
    //@Secured({"ROLE_USER","ROLE_ADMIN"})

    @GetMapping("listPartByDep/{idEvent}/{dep}")
    @ResponseBody
    public List<User> afficherParticipantByDepartement(@PathVariable("idEvent") Long idEvent, @PathVariable("dep") Departement departement) {
        return eventService.afficherParticipantByDepartement(idEvent, departement);
    }
    //@Secured({"ROLE_USER","ROLE_ADMIN"})

    @GetMapping("ListEventBeforeSystemeDate")
    public List<Event> ListEventBeforeSystemeDate() {
        return eventService.selectDate();
    }
    //@Secured({"ROLE_USER","ROLE_ADMIN"})

    @GetMapping("ListPartByDate")
    public List<User> ListParticipantBeforeSystemDate() {
        return eventService.ListParticipantBeforeSystemDate();
    }

    //@Secured({"ROLE_USER","ROLE_ADMIN"})

    @GetMapping("MailingListParticips/{idEvent}")
    public List<String> ListUserByEvent(@PathVariable("idEvent") Long idEvent) {
        return eventService.ListUserByEvent(idEvent);
    }
    //@Secured({"ROLE_USER","ROLE_ADMIN"})

    @GetMapping("ListParticipantEvent/{idEvent}")
    @ResponseBody
    public List<User> ListParticipantEvent(@PathVariable("idEvent") Long idEvent) {
        return eventService.ListParticipantEvent(idEvent);
    }
    //@Secured({"ROLE_USER","ROLE_ADMIN"})

    @GetMapping("getEventOneDayBefore")
    public List<Event> getEventOneDayBefore() {
        return eventService.getEventOneDayBefore();
    }

    //@Secured({"ROLE_USER","ROLE_ADMIN"})

    @PostMapping("listEmail")
    public void afficherListEmail() {
        eventService.afficherListEmail();
    }


    @GetMapping("FilterByInterestCenter/{interest}")
    List<String> sendEventToUserByInterestCenter(@PathVariable("interest") IneterestCenter ineterestCenter) {
        return eventService.sendEventToUserByInterestCenter(ineterestCenter);
    }

    @PostMapping("sendMailModifie")
    public void sendEmailNotifAgent() throws MessagingException {
        eventService.sendEmailNotifAgent();
    }

    @PostMapping("PDF/{idEvent}")
    public String toPDF(@PathVariable("idEvent") Long idEvent) {
   return eventService.toPDF(idEvent);
    }

    @GetMapping("EventRecom")
    public List<Event> ListEventRecommende(){
        return eventService.ListEventRecommende();
    }

    }
