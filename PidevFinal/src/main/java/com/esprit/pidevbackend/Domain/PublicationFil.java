package com.esprit.pidevbackend.Domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PublicationFil implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long idph;
	private int likes;
	private String tex;
	private String photo;
	private String video;
	private boolean droit;
	@Temporal(TemporalType.DATE)
	private Date dateP;
	private boolean activeP;

	
	@OneToMany(mappedBy = "publics", cascade = CascadeType.ALL)
	private List<CommentFil> comments;
	
	public PublicationFil() {
		
	}

	
	

}
