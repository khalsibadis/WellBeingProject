package com.esprit.pidevbackend.Service;


import com.esprit.pidevbackend.Domain.*;

import javax.mail.MessagingException;
import java.util.Date;
import java.util.List;

public interface EventService {

    public void addEvent(Event event);

    public void deleteFacture(Long id);

    List<Event> getListEvent();

    public Event getEventById(Long id);

    public void updateEvent(Long id, Event event);

    public void addUserToEvent(Long idUser, Long idEvent);

    List<User> afficherListUserByDepartment(Departement dep);

    List<User> afficherListUserByOffice(Office office);


    public void ModifierEvent(Event event);

    public void addEventToFavoris(Long idEvent, Long idUser);

    List<User> afficherParticipantByDepartement(Long idEvent, Departement departement);

    List<Event> ListEventBeforeSystemeDate(Date dateEvent);

    List<Event> selectDate();

    List<User> ListParticipantBeforeSystemDate();

    List<String> ListUserByEvent(Long idEvent);

    List<User> ListParticipantEvent(Long idEvent);


    List<Event> getEventOneDayBefore();

    public void afficherListEmail();

  //  Response sendListEmail(List<String> Listmail, Event event);

    List<String> sendEventToUserByInterestCenter(IneterestCenter ineterestCenter);

    public void sendEmailNotifAgent() throws MessagingException;

    public String toPDF(Long idEvent);

    public List<Event> ListEventRecommende();


}
