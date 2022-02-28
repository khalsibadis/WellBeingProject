package com.example.EventManage.services;

import com.example.EventManage.entities.Event;
import com.example.EventManage.entities.User;
import com.example.EventManage.enumeration.Departement;
import com.example.EventManage.enumeration.Office;
import com.example.EventManage.repositories.EventRepository;
import com.example.EventManage.repositories.UserRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Transactional
@Service
public class EventServiceImpl implements EventService {
    @Autowired
    EventRepository eventRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public void addEvent(Event event) {
        eventRepository.save(event);
    }

    @Override
    public void deleteFacture(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public List<Event> getListEvent() {
        return eventRepository.findAll();
    }

    @Override
    public void getEventById(Long id) {
        eventRepository.findById(id);
    }

    @Override
    public void updateEvent(Long id, Event event) {
        event = eventRepository.findById(id).orElse(null);
        eventRepository.save(event);
    }

    @Transactional
    @Override
    public void addUserToEvent(Long idUser, Long idEvent) {
        User user = userRepository.findById(idUser).orElse(null);
        Event event = eventRepository.findById(idEvent).orElse(null);
        event.getUsers().add(user);

    }

    @JsonIgnore
    @Override
    public List<User> afficherListUserByDepartment(Departement dep) {
        System.out.println("In serviceImpl +" + dep);
        return eventRepository.afficherListUserByDepartment(dep);
    }

    @Override
    public List<User> afficherListUserByOffice(Office office) {
        return eventRepository.afficherListUserByOffice(office);
    }

}
