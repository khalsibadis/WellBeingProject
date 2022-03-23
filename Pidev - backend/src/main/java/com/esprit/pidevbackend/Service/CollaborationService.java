package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.Collaboration;
import com.esprit.pidevbackend.Repository.ICollaboration;
import com.esprit.pidevbackend.Repository.IOffer;
import com.esprit.pidevbackend.Repository.IPublicity;
import com.esprit.pidevbackend.ServiceImp.ICollaborationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;


import java.util.List;

@Service
@Slf4j
public class CollaborationService implements ICollaborationService {
	@Autowired
	IOffer OfferRepo;
	
	@Autowired
	ICollaboration CollaborationRepo;
	
	@Autowired
	IPublicity PublicityRepo;


	@Override
	public List<Collaboration> retrieveAllCollaborations() {
		List<Collaboration> collaborations = (List<Collaboration>) CollaborationRepo.findAll();
		return collaborations;
	}

	@Override
	public void addCollaboration(Collaboration c) {
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
}
