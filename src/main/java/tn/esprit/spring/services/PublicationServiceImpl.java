package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Publication;
import tn.esprit.spring.repository.PublicationRepository;
import tn.esprit.spring.repository.QuestionRepository;

@Slf4j
@Service
public class PublicationServiceImpl implements IPublicationService {
	
	@Autowired
	PublicationRepository publicationRepository;

	@Override
	public void addPub(Publication pb)  {
    publicationRepository.save(pb);		
	}

	@Override
	public List<Publication> getpubs() {
		return (List<Publication>) publicationRepository.findAll();
	}

	

	@Override
	public void UpdatePb(int idp, Publication pb) {
		 pb = publicationRepository.findById(idp).orElse(null);
	        publicationRepository.save(pb);
		
	}

	@Override
	public void DeletePb(int idp) {
		publicationRepository.deleteById(idp);
		
	}

}
