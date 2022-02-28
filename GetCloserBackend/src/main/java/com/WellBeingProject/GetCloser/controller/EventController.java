package com.example.EventManage.controller;

import com.example.EventManage.entities.Event;
import com.example.EventManage.entities.User;
import com.example.EventManage.enumeration.Departement;
import com.example.EventManage.enumeration.Office;
import com.example.EventManage.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("event")
public class EventController {
    @Autowired
    EventService eventService;

    @PostMapping("addEvent")
    public void addEvent(@RequestBody Event event) {
        eventService.addEvent(event);
    }

    @DeleteMapping("{id}")
    public void deleteFacture(@PathVariable("id") Long id) {
        eventService.deleteFacture(id);
    }

    @GetMapping("listEvent")
    public List<Event> getListEvent() {
        return eventService.getListEvent();
    }

    @GetMapping("eventById/{id}")
    @ResponseBody
    public void getEventById(@PathVariable("id") Long id) {
        eventService.getEventById(id);
    }

    @PutMapping("ModifierEvent/{id}")
    public void updateEvent(Long id, Event event) {
        eventService.updateEvent(id, event);
    }

    @PostMapping("userToEvent/{idUser}/{idEvent}")
    public void addUserToEvent(@PathVariable("idUser") Long idUser, @PathVariable("idEvent") Long idEvent) {
        eventService.addUserToEvent(idUser, idEvent);
    }

    @GetMapping("ListUserByDep/{dep}")
    @ResponseBody
    List<User> afficherListUserByDepartment(@PathVariable("dep") Departement dep) {
        return eventService.afficherListUserByDepartment(dep);
    }

    @GetMapping("ListUserByOff/{off}")
    public List<User> afficherListUserByOffice(@PathVariable("off") Office office){
     return eventService.afficherListUserByOffice(office);
    }


}
