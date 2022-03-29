package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.User;
import org.springframework.mail.MailException;

import javax.mail.MessagingException;

public interface MailService {
    public void sendEmailNotifAgent(User agent) throws MessagingException;
    public void sendEmail(String email)throws MailException, MessagingException;
    public void sendEmailReservation(long idUser, long idOffer) throws MessagingException;
    public void sendRappelEmailReservation(long idReservation) throws MessagingException;
}
