package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.PublicationFil;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.PublicationRepository;
import tn.esprit.spring.repository.QuestionRepository;

@Slf4j
@Service
public class PublicationServiceImpl implements IPublicationService {
	
	@Autowired
	PublicationRepository publicationRepository;

	@Override
	public PublicationFil addPub(PublicationFil pb) {
		
		return publicationRepository.save(pb);
	}

	@Override
	public List<PublicationFil> getpubs() {
	
		return publicationRepository.findAll();
	}

	@Override
	public Optional<PublicationFil> finPubById(Long idp) {

		return publicationRepository.findById(idp);
	}

	@Override
	public void DeletePub(Long idp) {
		publicationRepository.deleteById(idp);
		
	}

	@Override
	public PublicationFil UpdatPub(PublicationFil pb) {

		return publicationRepository.save(pb);
	}

	
}
