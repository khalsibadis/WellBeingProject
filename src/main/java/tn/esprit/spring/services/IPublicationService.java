package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;


import tn.esprit.spring.entities.PublicationFil;


public interface IPublicationService {

	
		public PublicationFil addPub (PublicationFil pb);
	    public List<PublicationFil> getpubs();
	    public Optional<PublicationFil> finPubById(Long idp);
	    public void DeletePub (Long idp);
	    public PublicationFil UpdatPub (PublicationFil pb);

}
