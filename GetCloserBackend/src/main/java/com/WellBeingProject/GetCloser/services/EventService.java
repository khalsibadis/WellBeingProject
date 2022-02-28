package com.example.EventManage.services;

import com.example.EventManage.entities.Event;
import com.example.EventManage.entities.User;
import com.example.EventManage.enumeration.Departement;
import com.example.EventManage.enumeration.Office;

import java.util.List;

public interface EventService {

    public void addEvent(Event event);

    public void deleteFacture(Long id);

    List<Event> getListEvent();

    public void getEventById(Long id);

    public void updateEvent(Long id, Event event);

    public void addUserToEvent(Long idUser, Long idEvent);

    List<User> afficherListUserByDepartment(Departement dep);

    List<User> afficherListUserByOffice(Office office);
}
