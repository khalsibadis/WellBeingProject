package com.esprit.pidevbackend.Controller;

import com.esprit.pidevbackend.API.EmailSender;
import com.esprit.pidevbackend.Domain.Reservation;
import com.esprit.pidevbackend.ServiceImp.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.websocket.server.PathParam;

@RestController
public class EmailController {

    @Autowired
    EmailSender emailSender;

    //http://localhost:8080/addOffer
    @PostMapping("/email")
    @ResponseBody

    public void email(@RequestBody String toEmail,@RequestBody String body,@RequestBody String subject,@RequestBody String attchment) throws MessagingException {
        emailSender.sendMailWithAttachement(toEmail,body,subject,attchment);
    }
}
