package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.Publicity;
import com.esprit.pidevbackend.Repository.ICollaboration;
import com.esprit.pidevbackend.Repository.IOffer;
import com.esprit.pidevbackend.Repository.IPublicity;
import com.esprit.pidevbackend.ServiceImp.IPublicityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



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
	public Publicity addPublicity(Publicity p) {
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

}
