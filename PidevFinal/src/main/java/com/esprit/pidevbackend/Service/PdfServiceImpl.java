package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.*;
import com.esprit.pidevbackend.Repository.IReservation;
import com.esprit.pidevbackend.Repository.QVTRepsitory;
import com.esprit.pidevbackend.Repository.UserRepository;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PdfServiceImpl implements IPdfService {

    @Autowired
    UserRepository accountRepo;
    @Autowired
    QVTRepsitory qvtRepsitory;
    @Autowired
    IQuestionService iQuestionService;
    @Autowired
    IAnswerService iAnswerService;
    @Autowired
    IReservation reservationRepo;
	
	
	@Override
	public String toPDF(Long idUser,Long idQvt) {

	    QVT qvt=qvtRepsitory.findById(idQvt).orElse(null);
        User user=accountRepo.findById(idUser).orElse(null);


        String URL_file = null;
		
		 Date d = new Date();
         SimpleDateFormat formater = null;
         formater = new SimpleDateFormat("yyyyMMdd_HHmmss");
		
		try {
			try {
				try {
					try {

	                        URL_file = "D:\\dossier Developper\\"+user.getUsername()+formater.format(d)+".pdf";
	                        OutputStream file = new FileOutputStream(new File(URL_file));

	                        Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.GRAY);
	                        Font catFont15B = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, BaseColor.BLACK);
	                        Font AnswerCorrect = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, BaseColor.GREEN);

	                        Font catFont17Bcour = new Font(Font.FontFamily.COURIER, 9, Font.NORMAL, BaseColor.BLUE);
	                        Font subFontPara13N= new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.NORMAL, BaseColor.BLACK);
	                        
	                        Document my_pdf_report = new Document();
	                        PdfWriter.getInstance(my_pdf_report, file);
	                        my_pdf_report.open();

	                        ///Imageee
	                        Image img = null;

	                         img = Image.getInstance("C:\\Users\\aymen\\Desktop\\GetCloser_Logo.png");

	                        img.setAbsolutePosition(50,769);
	                        img.scaleAbsolute(70,50);
	                        my_pdf_report.add(img);

	                        //Dateeee
	                        DateFormat df = new SimpleDateFormat("dd MMMM yyyy");
	                        String dt = df.format(new Date());
	                        Paragraph dateStr = new Paragraph(dt, catFont15B);
		                      //separator
	                        Paragraph separator1 = new Paragraph("_______________________________________________________________________________" , subFontPara13N);
	                        
	                        Paragraph titre=new Paragraph(""+user.getUsername()+formater.format(d));
	                        dateStr.setAlignment(Element.ALIGN_RIGHT);
	                        separator1.setAlignment(Element.ALIGN_RIGHT);
	                        titre.setAlignment(Element.ALIGN_RIGHT);

	                      //espaceee
	                        Paragraph espace = new Paragraph(" ", subFont);
	                        espace.setAlignment(Element.ALIGN_LEFT);

//	                       titreee
	                        Paragraph titre2 = new Paragraph("DETAILS ABOUT QVT :" , catFont15B);
	                        titre2.setAlignment(Element.ALIGN_CENTER);

	                      //separator
	                        Paragraph separator = new Paragraph("_________________________________________________________" , subFontPara13N);
	                        separator.setAlignment(Element.ALIGN_CENTER);

                        Paragraph Celmargg11 = new Paragraph(new Phrase("User :"+user.getName() , catFont17Bcour));
                        Celmargg11.setIndentationLeft(430);
                        my_pdf_report.add(Celmargg11);
                        Paragraph Celmargg12 = new Paragraph(new Phrase("NBR Question : "+qvt.getNbrQuestion() , catFont17Bcour));
                        Celmargg12.setIndentationLeft(430);
                        my_pdf_report.add(Celmargg12);

                        if (qvt.getRQuizzes() !=null) {
                            Paragraph Celmargg13 = new Paragraph(new Phrase("BAD : "+qvt.getRQuizzes().getPourCentageBAD()+"%" , catFont17Bcour));
                            Celmargg13.setIndentationLeft(430);
                            my_pdf_report.add(Celmargg13);
                            Paragraph Celmargg14 = new Paragraph(new Phrase("GOOD : "+qvt.getRQuizzes().getPourCentageGood()+"%" , catFont17Bcour));
                            Celmargg14.setIndentationLeft(430);
                            my_pdf_report.add(Celmargg14);
                            Paragraph Celmargg15 = new Paragraph(new Phrase("EXCELLENT : "+qvt.getRQuizzes().getPourCentageEx()+"%" , catFont17Bcour));
                            Celmargg15.setIndentationLeft(430);
                            my_pdf_report.add(Celmargg15);
                        }
                        my_pdf_report.add(espace);
                        my_pdf_report.add(titre2);
                        my_pdf_report.add(espace);
                        my_pdf_report.add(espace);

                        List<Question>qs=iQuestionService.findAllQuestionByQVT(idQvt);
                       for (Question q :qs) {
                            int i=1;
                           my_pdf_report.add(separator);
                           Paragraph para2 = new Paragraph(i+" ) "+q.getQuestion()+" :" , subFontPara13N);
                           para2.setAlignment(Element.ALIGN_LEFT);
                           para2.setIndentationLeft(100);
                           my_pdf_report.add(para2);
                           i++;
                           List<Answer> answers=iAnswerService.findAllAnswerForQuestion(q.getId());

                           List<Answer> ansByUser=iAnswerService.findAllAnswerByUser(idUser);
                           for ( Answer a :answers ) {
                               Paragraph Celmargg = new Paragraph(new Phrase(""+a.getTypeAnswer() , subFontPara13N));
                               for ( Answer auser :ansByUser ) {
                               if (auser.getId()==a.getId()){
                                   Celmargg = new Paragraph(new Phrase(""+a.getTypeAnswer() , AnswerCorrect));
                                   Celmargg.setIndentationLeft(200);
                                 }
                               else{
                                   Celmargg.setIndentationLeft(200);
                                    }
                               }
                               my_pdf_report.add(Celmargg);

                           }
                       }

	                        my_pdf_report.close();
	                        file.close();
	                        
	          Runtime.getRuntime()
	                                .exec("rundll32 url.dll,FileProtocolHandler D:\\dossier Developper\\"+user.getUsername()+formater.format(d)+".pdf");

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
	
		return ""+user.getUsername()+formater.format(d)+".pdf";
	}


    @Override
    public String toPDFResrvation(Long idUser, Long idReservation) {
        Reservation r=reservationRepo.findById(idReservation).orElse(null);
        User u=accountRepo.findById(idUser).orElse(null);


        String URL_file = null;


        Date d = new Date();
        SimpleDateFormat formater = null;
        formater = new SimpleDateFormat("yyyyMMdd_HHmmss");

        try {
            try {
                try {
                    try {

                        URL_file = ".\\src\\main\\resources\\static\\Pdf" + "_" + formater.format(d) + ".pdf";
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
                        Paragraph titre2 = new Paragraph("DETAILS ABOUT RESERVATION ", catFont15B);
                        titre2.setAlignment(Element.ALIGN_CENTER);


                        PdfPTable table1 = new PdfPTable(4);
                        table1.setWidthPercentage(90);

                        ///Ligne 1
                        PdfPCell Cellnomb = new PdfPCell(new Phrase("Name", subFontPara13B));
                        Cellnomb.setBorder(Rectangle.NO_BORDER);
                        Cellnomb.setBackgroundColor(BaseColor.WHITE);

                        PdfPCell CellnombR = new PdfPCell(new Phrase(":  " + u.getName(), subFontPara13N));
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

                        PdfPCell Celltt = new PdfPCell(new Phrase(": " + r.getNmPalce(), subFontPara13N));
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
                        PdfPCell CelAdr1 = new PdfPCell(new Phrase("Star Date ", subFontPara13B));
                        CelAdr1.setBorder(Rectangle.NO_BORDER);
                        CelAdr1.setBackgroundColor(BaseColor.WHITE);


                        PdfPCell CelAdrr1 = new PdfPCell(new Phrase(": " + r.getStartDateRes(), subFontPara13N));
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
                        PdfPCell Celtm = new PdfPCell(new Phrase("End Date", subFontPara13B));
                        Celtm.setBorder(Rectangle.NO_BORDER);
                        Celtm.setBackgroundColor(BaseColor.WHITE);

                        PdfPCell Celtmm = new PdfPCell(new Phrase(": " + r.getEndDateRes(), subFontPara13N));
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


                        Paragraph finPage1 = new Paragraph(" Responsible Colaboration", smallBold);
                        finPage1.setAlignment(Element.ALIGN_RIGHT);


////////////////////////////Paageeeeeeeeeeeeeeeeee 2
                        Paragraph titre21 = new Paragraph(" : ", catFont17Bcour);
                        titre21.setAlignment(Element.ALIGN_CENTER);
                        PdfPTable table4 = new PdfPTable(3); // Create 2 columns in table.
                        PdfPCell cell1 = new PdfPCell(new Paragraph("Name"));
                        PdfPCell cell2 = new PdfPCell(new Paragraph("Email"));
                        PdfPCell cell3 = new PdfPCell(new Paragraph("number places"));
                        PdfPCell cell8 = new PdfPCell(new Paragraph("Price"));
                        table4.addCell(cell1);
                        table4.addCell(cell2);
                        table4.addCell(cell3);
                        table4.addCell(cell8);
                        my_pdf_report.add(separator);
                        my_pdf_report.add(titre21);


                        // Create cells

                        PdfPCell cell5 = new PdfPCell(new Paragraph(""+u.getName()));
                        PdfPCell cell6 = new PdfPCell(new Paragraph(""+u.getEmail()));
                        PdfPCell cell7 = new PdfPCell(new Paragraph(""+r.getNmPalce()));
                        PdfPCell cell9 = new PdfPCell(new Paragraph(""+r.getPriceTotal()));




                        // Add cells in table

                        table4.addCell(cell5);
                        table4.addCell(cell6);
                        table4.addCell(cell7);
                        table4.addCell(cell9);

                        //     my_pdf_report.add(table);




                        my_pdf_report.add(espace);
                        my_pdf_report.add(table4);
                        my_pdf_report.add(finPage1);



                        my_pdf_report.close();
                        file.close();

                        Runtime.getRuntime()
                                .exec("rundll32 url.dll,FileProtocolHandler .\\src\\main\\resources\\static\\Pdf" + "_" + formater.format(d) + ".pdf");
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

}
