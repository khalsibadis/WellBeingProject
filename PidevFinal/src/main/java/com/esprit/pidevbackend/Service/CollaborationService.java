package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.API.UploadImage;
import com.esprit.pidevbackend.Domain.*;
import com.esprit.pidevbackend.Repository.*;
import com.esprit.pidevbackend.Storage.WSService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Service
@Slf4j
@AllArgsConstructor
public class CollaborationService implements ICollaborationService {

	private IOffer OfferRepo;
	private ICollaboration CollaborationRepo;
	private IPublicity PublicityRepo;
	private UserRepository userRepo;
	private MailService mailService;
	private IPdfService pdfService;
	private UploadImage uploadImage;
	private IReservation reservationRepo;;
	private WSService wsService;




	@Override
	public List<Collaboration> retrieveAllCollaborations() {
		List<Collaboration> collaborations = (List<Collaboration>) CollaborationRepo.findAll();
		return collaborations;
	}

	@Override
	public void addCollaboration(Collaboration c, long idUser) throws InterruptedException {
		User user = userRepo.findById(idUser).get();
		wsService.notifyFrontend("add Collaboration");
		c.setUsers(user);
		CollaborationRepo.save(c);
	}

	@Override
	public void deleteCollaboration(Long id) {
		CollaborationRepo.deleteById(id);
	}

	@Override
	public Collaboration updateCollaboration(Collaboration c) {
		return CollaborationRepo.save(c);
	}

	@Override
	public Collaboration retrieveCollaboration(Long id) {
		Collaboration collaboration = CollaborationRepo.findById(id).orElse(null);
		return collaboration;
	}


	//offer

	@Override
	public List<Offer> retrieveAllOffers() {
		List<Offer> offers = (List<Offer>) OfferRepo.findAll();
		return offers;
	}

	@Override
	public void addOffer(Offer o, long idCollaboration) {
		Collaboration collaboration = CollaborationRepo.findById(idCollaboration).get();
		o.setCollaboration(collaboration);
		if(o.getRate() > 6) throw  new RuntimeException("You have passed rate");
		OfferRepo.save(o);
	}

	@Override
	public void deleteOffer(Long id) {
		OfferRepo.deleteById(id);
	}

	@Override
	public Offer updateOffer(Offer o) {
		return OfferRepo.save(o);
	}

	@Override
	public Offer retrieveOffer(Long id) {
		return OfferRepo.findById(id).orElse(null);
	}


	@Override
	@Transactional
	public float calculProm(long idOffer) {
		Offer o = OfferRepo.findById(idOffer).orElse(null);

		if (o.getHappy() == Happy.BLACK_FRIDAY) {
			o.setPromotion((o.getPrix() * 50) / 100);
		} else if (o.getHappy() == Happy.HAPPY_DAYS) {
			o.setPromotion((o.getPrix() * 20) / 100);
		} else if (o.getHappy() == Happy.HAPPY_HOUR) {
			o.setPromotion((o.getPrix() * 20) / 100);
		} else if(o.getHappy() == Happy.PROMOTION) {
			o.setPromotion((o.getPercentage() * o.getPrix()) / 100);
		}
		OfferRepo.save(o);
		return o.getPromotion();
	}

	//publicity

	@Override
	public List<Publicity> retrieveAllPublicitys() {
		List<Publicity> publicities = PublicityRepo.findAll();
		return publicities;
	}


	@Override
	public Publicity addPublicity(Publicity p , long idOffer) {
		Offer o = OfferRepo.findById( idOffer).get();
		if(o.getStarDateOf().isAfter(p.getStarDatePub()))throw  new RuntimeException("You have passed the start date") ;
		if(o.getEndDateOf().isBefore(p.getStarDatePub()))throw  new RuntimeException("You have passed the end date");
		//p.setPicture();
		//uploadImage.image();
		p.setOffers(o);
		return PublicityRepo.save(p);
	}

	@Override
	public void deletePublicity(Long id) {
		PublicityRepo.deleteById(id);
	}

	@Override
	public Publicity updatePublicity(Publicity p) {
		return PublicityRepo.save(p);
	}

	@Override
	public Publicity retrievePublicity(Long id) {
		Publicity publicity = PublicityRepo.findById(id).orElse(null);
		return publicity;
	}


	@Scheduled(cron="*/60 * * * * *")
	@Override
	public boolean dateOffer() {
		boolean b = false;
		long idPublicity=0;
		Publicity p =PublicityRepo.findById(idPublicity).orElse(null);
		LocalDate date = LocalDate.now();
		if(p.getStarDatePub().equals(date)) {
			OfferRepo.findById(idPublicity).orElse(null);
			b=true;
		}else if (date.equals(p.getEndDatePub())){
			OfferRepo.deleteById(idPublicity);
			b=false;
		}
		return b;
	}

	//reservation

	@SneakyThrows
	@Override
	@Transactional
	public Reservation reservation(long idUser, long idOffer, Reservation r)  {
		User u = userRepo.findById(idUser).orElse(null);
		Offer o = OfferRepo.findById(idOffer).orElse(null);
		if(o.getNplaces()<r.getNmPalce()) throw  new RuntimeException("Insufficient number of places");
		if(o.getStarDateOf().isAfter(r.getStartDateRes()))throw  new RuntimeException("You have passed the start date") ;
		if(o.getEndDateOf().isBefore(r.getEndDateRes()))throw  new RuntimeException("You have passed the end date");
		r.setUserRes(u);
		r.setOffersRes(o);
		r.setPriceTotal(r.getNmPalce() * o.getPromotion());
		mailService.sendEmailReservation(idUser,idOffer);
		reservationRepo.save(r);
		pdfService.toPDFResrvation(idUser,idOffer);
		o.setNplaces(o.getNplaces()-r.getNmPalce());
		return r;
	}

	@Override
	public float prixTotale(long idReservation) {
		Reservation res =reservationRepo.findById(idReservation).get();
		List<Reservation> r = (List<Reservation>) reservationRepo.findAll();
		float t=0;
		for(Reservation re : r){
			if(re.getUserRes().getId() == res.getUserRes().getId()){
				t = t + re.getPriceTotal();
			}
		}
		return t;
	}

	@Override
	public List<Reservation> findAll() {
		return  reservationRepo.findAll();
	}

	@Override
	public List<Reservation> listAll() {
		return reservationRepo.findAll();
	}


	@Scheduled(cron="*/30 * * * * *")
	public void findAllByStartDateResIsBefore( ) throws MessagingException {
		List<Reservation> reservationsWeek= reservationRepo.findAllByStartDateResIsBefore(LocalDateTime.now().plusDays(7));
		List<Reservation> reservationsDay = reservationRepo.findAllByStartDateResIsBefore(LocalDateTime.now().plusDays(1));
		for (Reservation r : reservationsWeek){
			r.getUserRes().getEmail();
			List<Reservation> listRe = listAll();
			mailService.sendRappelEmailReservation(r.getUserRes().getId());
		}
		for (Reservation r : reservationsDay){
			r.getUserRes().getEmail();
			List<Reservation> listRe = listAll();
			mailService.sendRappelEmailReservation(r.getUserRes().getId());
		}
	}

	@Override
	public int differenceStartDateAndEndDatePub(String dateStart, String dateEnd){
		DateTimeFormatter format = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
		LocalDate dateD = LocalDate.parse(dateStart, format);
		LocalDate dateF = LocalDate.parse(dateEnd, format);
		int periodDays;
		int yearDef = dateF.getYear() - dateD.getYear();
		if (yearDef == 0) {
			periodDays = dateF.getDayOfYear() - dateD.getDayOfYear();
			return periodDays;
		} else {
			int nbrYears = yearDef * 365;
			periodDays = (dateF.getDayOfYear() - dateD.getDayOfYear()) + nbrYears;
			return periodDays;
		}
	}



}
