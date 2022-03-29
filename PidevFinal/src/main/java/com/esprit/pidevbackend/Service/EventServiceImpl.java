package com.esprit.pidevbackend.Service;


import com.esprit.pidevbackend.Domain.*;
import com.esprit.pidevbackend.Repository.CommentaireRepository;
import com.esprit.pidevbackend.Repository.EventRepository;
import com.esprit.pidevbackend.Repository.UserRepository;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.io.*;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Transactional
@Service
public class EventServiceImpl implements EventService {
    @Autowired
    EventRepository eventRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    public JavaMailSender emailSender;
    @Autowired
    CommentaireService commentaireService;

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
    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
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
        if (event.getNbrParticipate()<event.getNbrPlace()) {
            event.setNbrParticipate(event.getNbrParticipate()+1);
            event.getUsers().add(user);
        }

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

    @Override
    public void ModifierEvent(Event event) {
        eventRepository.save(event);

    }

    @Transactional
    @Override
    public void addEventToFavoris(Long idEvent, Long idUser) {

    }

    @Override
    public List<User> afficherParticipantByDepartement(Long idEvent, Departement departement) {
        return eventRepository.afficherParticipantByDepartement(idEvent, departement);

    }

    @Override
    public List<Event> ListEventBeforeSystemeDate(Date dateEvent) {

        return eventRepository.ListEventBeforeSystemeDate(dateEvent);
    }

    @Override
    public List<Event> selectDate() {
        Date date = eventRepository.dateTomorrow();
        System.out.println("date de demain" + eventRepository.dateTomorrow());
        List<Event> events = ListEventBeforeSystemeDate(date);
        System.out.println(events);
        return events;
    }


    @Override
    public List<User> ListParticipantBeforeSystemDate() {
        return eventRepository.ListParticipantBeforeSystemDate();
    }

    @Override
    public List<String> ListUserByEvent(Long idEvent) {
        return eventRepository.ListUserByEvent(idEvent);
    }

    @Override
    public List<User> ListParticipantEvent(Long idEvent) {
        return eventRepository.ListParticipantEvent(idEvent);
    }

    @Override
    public List<Event> getEventOneDayBefore() {
        return eventRepository.getEventOneDayBefore();
    }

    //  @Scheduled(cron = "*/5 * * * * *")
    @Override
    public void afficherListEmail() {
        List<Event> events = eventRepository.getEventOneDayBefore();
        for (Event event : events) {
            List<String> listEmail = eventRepository.ListUserByEvent(event.getId());
            try {

                SimpleMailMessage message = new SimpleMailMessage();
                for (String email : listEmail) {
                    message.setTo(email);
                    message.setSubject("Rappel Event  " + event.getName());
                    message.setText("demain vous aurez un evenement de " + event.getName());
                    System.out.println(email);
                    emailSender.send(message);

                }


                System.out.println(message);

            } catch (Exception ex) {

            }
        }
    }

  /*  @Override
    public Response sendListEmail(List<String> Listmail, Event event) {
        Response response = new Response();
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            for (String email : Listmail) {
                message.setTo(email);
                message.setSubject("Rappel Event  " + event.getName());
                message.setText("demain vous aurez un evenement de " + event.getName());
            }


            emailSender.send(message);
            System.out.println(message);
            response.setCode(0);
            response.setMessage("Email send ok!");
        } catch (Exception ex) {
            response.setCode(1);
            response.setMessage("Error sending email: " + ex.getMessage());
        }

        return response;
    }*/

    @Override
    public List<String> sendEventToUserByInterestCenter(IneterestCenter ineterestCenter) {
        return eventRepository.sendEventToUserByInterestCenter(ineterestCenter);
    }
////////////////////////Mail Finaaaaaaaaaaaal///
    // @Scheduled(cron = "*/5 * * * * *")
    // @Scheduled(cron = "* */8 * * *")


    @Override
    public void sendEmailNotifAgent() throws MessagingException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        StringBuilder buf = new StringBuilder();
        List<Event> events = eventRepository.getEventOneDayBefore();

        for (Event event : events) {
            List<String> listEmail = eventRepository.ListUserByEvent(event.getId());
            SimpleMailMessage message = new SimpleMailMessage();
            for (String email : listEmail) {
             /*   message.setTo(email);
                message.setSubject("Rappel Event  " + event.getName());
                message.setText("demain vous aurez un evenement de " + event.getName());
                System.out.println(email);
                emailSender.send(message);*/


                buf.append("\"<html>\n" + "  <head>\n" + "    <meta name=\"viewport\" content=\"width=device-width\" />\n"
                        + "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n"
                        + "    <title>Simple Transactional Email</title>\n" + "    <style>\n"
                        + "      /* -------------------------------------\n" + "          GLOBAL RESETS\n"
                        + "      ------------------------------------- */\n" + "      \n"
                        + "      /*All the styling goes here*/\n" + "      \n" + "      img {\n" + "        border: none;\n"
                        + "        -ms-interpolation-mode: bicubic;\n" + "        max-width: 100%; \n" + "      }\n" + "\n"
                        + "      body {\n" + "        background-color: #f6f6f6;\n" + "        font-family: sans-serif;\n"
                        + "        -webkit-font-smoothing: antialiased;\n" + "        font-size: 14px;\n"
                        + "        line-height: 1.4;\n" + "        margin: 0;\n" + "        padding: 0;\n"
                        + "        -ms-text-size-adjust: 100%;\n" + "        -webkit-text-size-adjust: 100%; \n" + "      }\n"
                        + "\n" + "      table {\n" + "        border-collapse: separate;\n" + "        mso-table-lspace: 0pt;\n"
                        + "        mso-table-rspace: 0pt;\n" + "        width: 100%; }\n" + "        table td {\n"
                        + "          font-family: sans-serif;\n" + "          font-size: 14px;\n"
                        + "          vertical-align: top; \n" + "      }\n" + "\n"
                        + "      /* -------------------------------------\n" + "          BODY & CONTAINER\n"
                        + "      ------------------------------------- */\n" + "\n" + "      .body {\n"
                        + "        background-color: #f6f6f6;\n" + "        width: 100%; \n" + "      }\n" + "\n"
                        + "      /* Set a max-width, and make it display as block so it will automatically stretch to that width, but will also shrink down on a phone or something */\n"
                        + "      .container {\n" + "        display: block;\n" + "        margin: 0 auto !important;\n"
                        + "        /* makes it centered */\n" + "        max-width: 580px;\n" + "        padding: 10px;\n"
                        + "        width: 580px; \n" + "      }\n" + "\n"
                        + "      /* This should also be a block element, so that it will fill 100% of the .container */\n"
                        + "      .content {\n" + "        box-sizing: border-box;\n" + "        display: block;\n"
                        + "        margin: 0 auto;\n" + "        max-width: 580px;\n" + "        padding: 10px; \n"
                        + "      }\n" + "\n" + "      /* -------------------------------------\n"
                        + "          HEADER, FOOTER, MAIN\n" + "      ------------------------------------- */\n"
                        + "      .main {\n" + "        background: #ffffff;\n" + "        border-radius: 3px;\n"
                        + "        width: 100%; \n" + "      }\n" + "\n" + "      .wrapper {\n"
                        + "        box-sizing: border-box;\n" + "        padding: 20px; \n" + "      }\n" + "\n"
                        + "      .content-block {\n" + "        padding-bottom: 10px;\n" + "        padding-top: 10px;\n"
                        + "      }\n" + "\n" + "      .footer {\n" + "        clear: both;\n" + "        margin-top: 10px;\n"
                        + "        text-align: center;\n" + "        width: 100%; \n" + "      }\n" + "        .footer td,\n"
                        + "        .footer p,\n" + "        .footer span,\n" + "        .footer a {\n"
                        + "          color: #999999;\n" + "          font-size: 12px;\n" + "          text-align: center; \n"
                        + "      }\n" + "\n" + "      /* -------------------------------------\n" + "          TYPOGRAPHY\n"
                        + "      ------------------------------------- */\n" + "      h1,\n" + "      h2,\n" + "      h3,\n"
                        + "      h4 {\n" + "        color: #000000;\n" + "        font-family: sans-serif;\n"
                        + "        font-weight: 400;\n" + "        line-height: 1.4;\n" + "        margin: 0;\n"
                        + "        margin-bottom: 30px; \n" + "      }\n" + "\n" + "      h1 {\n" + "        font-size: 35px;\n"
                        + "        font-weight: 300;\n" + "        text-align: center;\n"
                        + "        text-transform: capitalize; \n" + "      }\n" + "\n" + "      p,\n" + "      ul,\n"
                        + "      ol {\n" + "        font-family: sans-serif;\n" + "        font-size: 14px;\n"
                        + "        font-weight: normal;\n" + "        margin: 0;\n" + "        margin-bottom: 15px; \n"
                        + "      }\n" + "        p li,\n" + "        ul li,\n" + "        ol li {\n"
                        + "          list-style-position: inside;\n" + "          margin-left: 5px; \n" + "      }\n" + "\n"
                        + "      a {\n" + "        color: #3498db;\n" + "        text-decoration: underline; \n" + "      }\n"
                        + "\n" + "      /* -------------------------------------\n" + "          BUTTONS\n"
                        + "      ------------------------------------- */\n" + "      .btn {\n"
                        + "        box-sizing: border-box;\n" + "        width: 100%; }\n"
                        + "        .btn > tbody > tr > td {\n" + "          padding-bottom: 15px; }\n"
                        + "        .btn table {\n" + "          width: auto; \n" + "      }\n" + "        .btn table td {\n"
                        + "          background-color: #ffffff;\n" + "          border-radius: 5px;\n"
                        + "          text-align: center; \n" + "      }\n" + "        .btn a {\n"
                        + "          background-color: #ffffff;\n" + "          border: solid 1px #3498db;\n"
                        + "          border-radius: 5px;\n" + "          box-sizing: border-box;\n"
                        + "          color: #3498db;\n" + "          cursor: pointer;\n" + "          display: inline-block;\n"
                        + "          font-size: 14px;\n" + "          font-weight: bold;\n" + "          margin: 0;\n"
                        + "          padding: 12px 25px;\n" + "          text-decoration: none;\n"
                        + "          text-transform: capitalize; \n" + "      }\n" + "\n" + "      .btn-primary table td {\n"
                        + "        background-color: #3498db; \n" + "      }\n" + "\n" + "      .btn-primary a {\n"
                        + "        background-color: #3498db;\n" + "        border-color: #3498db;\n"
                        + "        color: #ffffff; \n" + "      }\n" + "\n" + "      /* -------------------------------------\n"
                        + "          OTHER STYLES THAT MIGHT BE USEFUL\n" + "      ------------------------------------- */\n"
                        + "      .last {\n" + "        margin-bottom: 0; \n" + "      }\n" + "\n" + "      .first {\n"
                        + "        margin-top: 0; \n" + "      }\n" + "\n" + "      .align-center {\n"
                        + "        text-align: center; \n" + "      }\n" + "\n" + "      .align-right {\n"
                        + "        text-align: right; \n" + "      }\n" + "\n" + "      .align-left {\n"
                        + "        text-align: left; \n" + "      }\n" + "\n" + "      .clear {\n" + "        clear: both; \n"
                        + "      }\n" + "\n" + "      .mt0 {\n" + "        margin-top: 0; \n" + "      }\n" + "\n"
                        + "      .mb0 {\n" + "        margin-bottom: 0; \n" + "      }\n" + "\n" + "      .preheader {\n"
                        + "        color: transparent;\n" + "        display: none;\n" + "        height: 0;\n"
                        + "        max-height: 0;\n" + "        max-width: 0;\n" + "        opacity: 0;\n"
                        + "        overflow: hidden;\n" + "        mso-hide: all;\n" + "        visibility: hidden;\n"
                        + "        width: 0; \n" + "      }\n" + "\n" + "      .powered-by a {\n"
                        + "        text-decoration: none; \n" + "      }\n" + "\n" + "      hr {\n" + "        border: 0;\n"
                        + "        border-bottom: 1px solid #f6f6f6;\n" + "        margin: 20px 0; \n" + "      }\n" + "\n"
                        + "      /* -------------------------------------\n"
                        + "          RESPONSIVE AND MOBILE FRIENDLY STYLES\n"
                        + "      ------------------------------------- */\n"
                        + "      @media only screen and (max-width: 620px) {\n" + "        table[class=body] h1 {\n"
                        + "          font-size: 28px !important;\n" + "          margin-bottom: 10px !important; \n"
                        + "        }\n" + "        table[class=body] p,\n" + "        table[class=body] ul,\n"
                        + "        table[class=body] ol,\n" + "        table[class=body] td,\n"
                        + "        table[class=body] span,\n" + "        table[class=body] a {\n"
                        + "          font-size: 16px !important; \n" + "        }\n" + "        table[class=body] .wrapper,\n"
                        + "        table[class=body] .article {\n" + "          padding: 10px !important; \n" + "        }\n"
                        + "        table[class=body] .content {\n" + "          padding: 0 !important; \n" + "        }\n"
                        + "        table[class=body] .container {\n" + "          padding: 0 !important;\n"
                        + "          width: 100% !important; \n" + "        }\n" + "        table[class=body] .main {\n"
                        + "          border-left-width: 0 !important;\n" + "          border-radius: 0 !important;\n"
                        + "          border-right-width: 0 !important; \n" + "        }\n"
                        + "        table[class=body] .btn table {\n" + "          width: 100% !important; \n" + "        }\n"
                        + "        table[class=body] .btn a {\n" + "          width: 100% !important; \n" + "        }\n"
                        + "        table[class=body] .img-responsive {\n" + "          height: auto !important;\n"
                        + "          max-width: 100% !important;\n" + "          width: auto !important; \n" + "        }\n"
                        + "      }\n" + "\n" + "      /* -------------------------------------\n"
                        + "          PRESERVE THESE STYLES IN THE HEAD\n" + "      ------------------------------------- */\n"
                        + "      @media all {\n" + "        .ExternalClass {\n" + "          width: 100%; \n" + "        }\n"
                        + "        .ExternalClass,\n" + "        .ExternalClass p,\n" + "        .ExternalClass span,\n"
                        + "        .ExternalClass font,\n" + "        .ExternalClass td,\n" + "        .ExternalClass div {\n"
                        + "          line-height: 100%; \n" + "        }\n" + "        .apple-link a {\n"
                        + "          color: inherit !important;\n" + "          font-family: inherit !important;\n"
                        + "          font-size: inherit !important;\n" + "          font-weight: inherit !important;\n"
                        + "          line-height: inherit !important;\n" + "          text-decoration: none !important; \n"
                        + "        }\n" + "        #MessageViewBody a {\n" + "          color: inherit;\n"
                        + "          text-decoration: none;\n" + "          font-size: inherit;\n"
                        + "          font-family: inherit;\n" + "          font-weight: inherit;\n"
                        + "          line-height: inherit;\n" + "        }\n" + "        .btn-primary table td:hover {\n"
                        + "          background-color: #34495e !important; \n" + "        }\n"
                        + "        .btn-primary a:hover {\n" + "          background-color: #34495e !important;\n"
                        + "          border-color: #34495e !important; \n" + "        } \n" + "      }\n" + "\n"
                        + "    </style>\n" + "  </head>\n" + "  <body class=\"\">\n"
                        + "    <span class=\"preheader\">This is preheader text. it's a reminder of an event</span>\n"
                        + "    <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"body\">\n"
                        + "      <tr>\n" + "        <td>&nbsp;</td>\n" + "        <td class=\"container\">\n"
                        + "          <div class=\"content\">\n" + "\n" + "            <!-- START CENTERED WHITE CONTAINER -->\n"
                        + "            <table role=\"presentation\" class=\"main\">\n"
                        + "                    <img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQK9p0bVz_acon26T4E6nDchdfx6YHM9N_FFA&usqp=CAU\"></a>\n" + "\n"

                        + "              <!-- START MAIN CONTENT AREA -->\n" + "              <tr>\n"
                        + "                <td class=\"wrapper\">\n"
                        + "                  <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n"
                        + "                    <tr>\n" + "                      <td>\n"
                        + "                        <b>Rattle Event : " + event.getName() + " ,\"</b>\n"
                        + "                        <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"btn btn-primary\">\n"
                        + "                          <tbody>\n" + "                            <tr>\n"
                        + "                              <td align=\"left\">\n"
                        + "                                <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n"
                        + "                                  <tbody>\n" + "                                  </tbody>\n"
                        + "                                </table>\n" + "                              </td>\n"
                        + "                            </tr>\n" + "                          </tbody>\n"
                        + "                        </table>\n" + "<p>We Hope You Are Doing Well ! </p>\n"
                        + "                        <b>We are now pleased to inform you that you have the event of : " + event.getIneterestCenter() + " ,\"</b>\n"
                        + "                        <b>place Event : " + event.getPlace() + " ,\"</b>\n" + "<br>"
                        + "                        <b>date Event : " + event.getDate() + " ,\"</b>\n"
                        + "								<br/>"
                        + "							<p>All the best.</p>\n"
                        + "                        <p>Thank you.</p>\n"
                        + "                        <p>Kind Regards !                 <br/> Responsable Events.</p>\n"
                        + "                      </td>\n" + "                    </tr>\n" + "                  </table>\n"
                        + "                </td>\n" + "              </tr>\n" + "\n"
                        + "            <!-- END MAIN CONTENT AREA -->\n" + "            </table>\n"
                        + "            <!-- END CENTERED WHITE CONTAINER -->\n" + "\n" + "            <!-- START FOOTER -->\n"
                        + "            <div class=\"footer\">\n"
                        + "              <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n"
                        + "                <tr>\n" + "                  <td class=\"content-block\">\n"
                        + "                    <span class=\"apple-link\">Responsable events,El-ghazela, Tunisie</span>\n"
                        + "                  </td>\n" + "                </tr>\n" + "                <tr>\n"
                        + "                  <td class=\"content-block powered-by\">\n"
                        + "                  </td>\n" + "                </tr>\n" + "              </table>\n"
                        + "            </div>\n" + "            <!-- END FOOTER -->\n" + "\n" + "          </div>\n"
                        + "        </td>\n" + "        <td>&nbsp;</td>\n" + "      </tr>\n" + "    </table>\n" + "  </body>\n"
                        + "</html>\"");
                String messaage = buf.toString();
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
                helper.setTo(email);
                helper.setSubject("Rappel Event  " + event.getName());
                helper.setText(messaage, messaage);
                System.out.println(email);

                emailSender.send(mimeMessage);

            }
        }
    }

    @Override
    public String toPDF(Long idEvent) {

        String URL_file = null;
        Event event = eventRepository.findById(idEvent).orElse(null);
        List<User> listParticipantEvent = eventRepository.ListParticipantEvent(idEvent);

        Date d = new Date();
        SimpleDateFormat formater = null;
        formater = new SimpleDateFormat("yyyyMMdd_HHmmss");

        try {
            try {
                try {
                    try {

                        URL_file = "D:\\dossier Developper\\"+formater.format(d)+".pdf";

                        OutputStream file = new FileOutputStream(new File(URL_file));
//                         Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD, BaseColor.DARK_GRAY);
//                         Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD, BaseColor.RED);
                        Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.GRAY);
                        Font catFont15B = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, BaseColor.BLACK);
//                         Font catFont17B = new Font(Font.FontFamily.TIMES_ROMAN, 17, Font.BOLD, BaseColor.BLACK);
                        Font catFont17Bcour = new Font(Font.FontFamily.COURIER, 17, Font.BOLD, BaseColor.BLACK);
//                         Font catFont14N = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.NORMAL, BaseColor.BLACK);
//                         Font catFont14B = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD, BaseColor.BLACK);
//                         Font catFont14Bcour = new Font(Font.FontFamily.COURIER, 14, Font.BOLD, BaseColor.BLACK);
                        Font subFontPara13B = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD, BaseColor.BLACK);
//                         Font subFontPara12Ncour = new Font(Font.FontFamily.COURIER, 12, Font.NORMAL, BaseColor.BLACK);
//                         Font subFontPara12CScour = new Font(Font.FontFamily.COURIER, 14, Font.UNDERLINE | Font.BOLD , BaseColor.BLACK);
//                         Font subFontPara12Bcour = new Font(Font.FontFamily.COURIER, 12, Font.BOLD , BaseColor.BLACK);
                        Font subFontPara13N = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.NORMAL, BaseColor.BLACK);
                        Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD);

                        Document my_pdf_report = new Document();
                        PdfWriter.getInstance(my_pdf_report, file);
                        my_pdf_report.open();


                        ///Imageee
                        Image imgBank = null;


                        //Dateeee
                        DateFormat df = new SimpleDateFormat("dd MMMM yyyy");
                        String dt = df.format(new Date());
                        Paragraph dateStr = new Paragraph(dt, catFont15B);
                        //separator
                        Paragraph separator1 = new Paragraph("_______________________________________________________________________________", subFontPara13N);

                        Paragraph titre = new Paragraph("ESTIMATION_" + "_" + formater.format(d));
                        Paragraph titreBank = new Paragraph(" BANK", catFont15B);
                        dateStr.setAlignment(Element.ALIGN_RIGHT);
                        //titreBank.setAlignment(Element.ALIGN_RIGHT);
                        separator1.setAlignment(Element.ALIGN_RIGHT);
                        titre.setAlignment(Element.ALIGN_RIGHT);


                        //espaceee
                        Paragraph espace = new Paragraph(" ", subFont);
                        espace.setAlignment(Element.ALIGN_LEFT);

                        //para1
                        Paragraph para1 = new Paragraph(" ", catFont15B);
                        para1.setAlignment(Element.ALIGN_LEFT);
                        Paragraph para2 = new Paragraph(""
                                + " ", subFontPara13N);
                        para2.setAlignment(Element.ALIGN_LEFT);


                        Paragraph separator = new Paragraph("_________________________________________________________", subFontPara13N);
                        separator.setAlignment(Element.ALIGN_CENTER);

                        //titreee
                        Paragraph titre2 = new Paragraph("DETAILS ABOUT EVENT ", catFont15B);
                        titre2.setAlignment(Element.ALIGN_CENTER);


                        PdfPTable table1 = new PdfPTable(4);
                        table1.setWidthPercentage(90);

                        ///Ligne 1
                        PdfPCell Cellnomb = new PdfPCell(new Phrase("Name", subFontPara13B));
                        Cellnomb.setBorder(Rectangle.NO_BORDER);
                        Cellnomb.setBackgroundColor(BaseColor.WHITE);

                        PdfPCell CellnombR = new PdfPCell(new Phrase(":  " + event.getName(), subFontPara13N));
                        CellnombR.setBorder(Rectangle.NO_BORDER);
                        CellnombR.setBackgroundColor(BaseColor.WHITE);
                        CellnombR.setColspan(3);


                        table1.addCell(Cellnomb);
                        table1.addCell(CellnombR);

                        PdfPCell CellnombRN = new PdfPCell(new Phrase(""));
                        CellnombRN.setBorder(Rectangle.NO_BORDER);
                        CellnombRN.setBackgroundColor(BaseColor.WHITE);

                        //space
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);


                        /////Ligne 2
                        PdfPCell Cellt = new PdfPCell(new Phrase("Place", subFontPara13B));
                        Cellt.setBorder(Rectangle.NO_BORDER);
                        Cellt.setBackgroundColor(BaseColor.WHITE);

                        PdfPCell Celltt = new PdfPCell(new Phrase(": " + event.getPlace(), subFontPara13N));
                        Celltt.setBorder(Rectangle.NO_BORDER);
                        Celltt.setBackgroundColor(BaseColor.WHITE);
                        Celltt.setColspan(3);

                        table1.addCell(Cellt);
                        table1.addCell(Celltt);

                        //space
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);

                        /////Ligne 3
                        PdfPCell CelAdr1 = new PdfPCell(new Phrase("Date ", subFontPara13B));
                        CelAdr1.setBorder(Rectangle.NO_BORDER);
                        CelAdr1.setBackgroundColor(BaseColor.WHITE);


                        PdfPCell CelAdrr1 = new PdfPCell(new Phrase(": " + event.getDate(), subFontPara13N));
                        CelAdrr1.setBorder(Rectangle.NO_BORDER);
                        CelAdrr1.setBackgroundColor(BaseColor.WHITE);
                        CelAdrr1.setColspan(3);


                        table1.addCell(CelAdr1);
                        table1.addCell(CelAdrr1);


                        //space
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);


                        /////Ligne 4
                        PdfPCell Celtm = new PdfPCell(new Phrase("Type", subFontPara13B));
                        Celtm.setBorder(Rectangle.NO_BORDER);
                        Celtm.setBackgroundColor(BaseColor.WHITE);

                        PdfPCell Celtmm = new PdfPCell(new Phrase(": " + event.getIneterestCenter(), subFontPara13N));
                        Celtmm.setBorder(Rectangle.NO_BORDER);
                        Celtmm.setBackgroundColor(BaseColor.WHITE);
                        Celtmm.setColspan(3);

                        table1.addCell(Celtm);
                        table1.addCell(Celtmm);


                        //space
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);


                        //space
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);
                        table1.addCell(CellnombRN);

                        my_pdf_report.add(separator1);

//                         my_pdf_report.add(espace);
                        my_pdf_report.add(espace);
//
                        my_pdf_report.add(para1);
                        my_pdf_report.add(para2);
//
                        my_pdf_report.add(titre2);
                        my_pdf_report.add(espace);
                        my_pdf_report.add(table1);





                        my_pdf_report.add(espace);


                        Paragraph finPage1 = new Paragraph(" Responsable Events", smallBold);
                        finPage1.setAlignment(Element.ALIGN_RIGHT);


////////////////////////////Paageeeeeeeeeeeeeeeeee 2
                        Paragraph titre21 = new Paragraph("Liste des participants : ", catFont17Bcour);
                        titre21.setAlignment(Element.ALIGN_CENTER);
                        PdfPTable table4 = new PdfPTable(3); // Create 2 columns in table.
                        PdfPCell cell1 = new PdfPCell(new Paragraph("Nom"));
                        PdfPCell cell2 = new PdfPCell(new Paragraph("Email"));
                        PdfPCell cell3 = new PdfPCell(new Paragraph("departement"));
                        table4.addCell(cell1);
                        table4.addCell(cell2);
                        table4.addCell(cell3);
                        my_pdf_report.add(separator);
                        my_pdf_report.add(titre21);
                        for (User user : listParticipantEvent) {

                            // Create cells

                            PdfPCell cell4 = new PdfPCell(new Paragraph(""+user.getName()));
                            PdfPCell cell5 = new PdfPCell(new Paragraph(""+user.getEmail()));
                            PdfPCell cell6 = new PdfPCell(new Paragraph(""+user.getDepartement()));



                            // Add cells in table

                            table4.addCell(cell4);
                            table4.addCell(cell5);
                            table4.addCell(cell6);

                            //     my_pdf_report.add(table);


                        }
                        my_pdf_report.add(espace);
                        my_pdf_report.add(table4);
                        my_pdf_report.add(finPage1);



                        my_pdf_report.close();
                        file.close();

                        Runtime.getRuntime()
                                .exec("rundll32 url.dll,FileProtocolHandler D:\\dossier Developper\\"+formater.format(d)+".pdf");
                        // p.waitFor(2, TimeUnit.SECONDS);


                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } catch (DocumentException e) {
                    e.printStackTrace();
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "ESTIMATION_" + "_" + formater.format(d) + ".pdf";
    }


    public List<Event> ListEventRecommende(){

        List<Event> events=eventRepository.findAll();

        for (Event e:events){
            int a=0,b=0,z=0,PourCentage=0;
            a=commentaireService.CountCommentsIsBlockedByEvent(e.getId());
            b=commentaireService.CountComments(e.getId());
            if (b!=0 || e.getNbrPlace()!=0) {
                PourCentage = (a * 100) / b;
                z = (e.getNbrParticipate() * 100) / e.getNbrPlace();
                PourCentage = (z - PourCentage) ;
                if (PourCentage>50){
                    e.setRecommondation(true);
                }
                else
                    e.setRecommondation(false);
            }
        }

        return eventRepository.EventRecommonde();
    }

}



