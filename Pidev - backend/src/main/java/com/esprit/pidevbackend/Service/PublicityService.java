package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.Offer;
import com.esprit.pidevbackend.Domain.Publicity;
import com.esprit.pidevbackend.Repository.ICollaboration;
import com.esprit.pidevbackend.Repository.IOffer;
import com.esprit.pidevbackend.Repository.IPublicity;
import com.esprit.pidevbackend.ServiceImp.IPublicityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class PublicityService implements IPublicityService {
	@Autowired
	IOffer OfferRepo;

	@Autowired
	ICollaboration CollaborationRepo;

	@Autowired
	IPublicity PublicityRepo;


	@Override
	public List<Publicity> retrieveAllPublicitys() {
		List<Publicity> publicities = PublicityRepo.findAll();
		return publicities;
	}

	@Override
	public Publicity addPublicity(Publicity p , long idOffer) {
		Offer offer = OfferRepo.findById( idOffer).get();
		p.setOffers(offer);
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


	@Override
	public boolean dateOffer(long idPublicity, Date starDateOf, Date finDateOf) {
		boolean b = false;
		LocalDate date = LocalDate.now();
		if(date.equals(starDateOf)) {
			OfferRepo.findById(idPublicity).orElse(null);
			b=true;
		}else if (date.equals(finDateOf)){
			OfferRepo.deleteById(idPublicity);
			b=false;
		}
		return b;
	}

	@Override
	public void saveImage(MultipartFile imageFile,Publicity publicity) throws IOException {
		Path currentPath = Paths.get(".");
		Path absolutePath = currentPath.toAbsolutePath();
		publicity.setPicture(absolutePath + "/src/main/resources/image/");
		byte[] bytes  = imageFile.getBytes();
		Path path =Paths.get(publicity.getPicture() + imageFile.getOriginalFilename() );
		Files.write(path,bytes);
	}

}
