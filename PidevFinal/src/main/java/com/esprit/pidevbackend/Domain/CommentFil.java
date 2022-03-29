package com.esprit.pidevbackend.Domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CommentFil implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long idcm; 
	private String contenu_cm;
	@Temporal(TemporalType.DATE)
	private Date date_cm;
	private boolean activeC;
	
	@ManyToOne
	@JsonIgnore
	private PublicationFil publics;
	
	
	
}
