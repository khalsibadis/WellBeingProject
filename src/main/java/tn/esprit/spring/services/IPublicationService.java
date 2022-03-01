package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Publication;
import tn.esprit.spring.entities.Theme;

public interface IPublicationService {
	
	 public void addPub(Publication pb);
	    public List<Publication> getpubs();
	    public void DeletePb (int idp);
	    public void UpdatePb (int idp ,Publication pb);

}
