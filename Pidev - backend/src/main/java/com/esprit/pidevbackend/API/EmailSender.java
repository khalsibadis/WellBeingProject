package com.esprit.pidevbackend.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailSender {
    @Autowired
    private JavaMailSender javaMailSender;
    public void sendMailWithAttachement (String toEmail,String body,String subject,String attchment) throws MessagingException {
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("willbieng7@gmail.com");
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setSubject(subject);

        FileSystemResource fileSystemResource= new FileSystemResource(new File(attchment));
        mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),fileSystemResource);
        javaMailSender.send(mimeMessage);

        System.out.println("Mail send sucessufully");
    }
}
