package com.esprit.pidevbackend.Domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@ToString
public class Offer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long  idOffer;
	String title;
	String descrption;
	Date starDate;
	Date endDate;
	int NPlaces;
	float promotion;
	int percentage;
	String localisation;

	
	@Enumerated(EnumType.STRING)
	Happy happy;
	
	@ManyToOne
	Collaboration collaboration;

	@OneToMany(mappedBy="offers", cascade=CascadeType.ALL)
	private Set<Publicity>  publicity;



	




}
