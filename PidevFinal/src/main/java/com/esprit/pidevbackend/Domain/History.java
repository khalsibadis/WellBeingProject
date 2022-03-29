package com.esprit.pidevbackend.Domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class History implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long idh;
	
	private String username;
	
	private String themeName;

	private String PhaseName;
	
	private int total;
	
	private int sore;
	
	
	
	@ManyToOne
	@JsonIgnore
	private Quiz quiz;
	
	public History() {
	}

	

	

	
}
