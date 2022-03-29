package com.esprit.pidevbackend.Domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

public class Offer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long  idOffer;
	String title;
	String descrption;
	LocalDateTime starDateOf;
	LocalDateTime endDateOf;
	float nplaces;
	float promotion;
	int percentage;
	String location;
	float prix;
	int rate ;

	
	@Enumerated(EnumType.STRING)
	Happy happy;

	@JsonIgnore
	@ManyToOne
	Collaboration collaboration;

	@JsonIgnore
	@OneToMany(mappedBy="offers", cascade=CascadeType.ALL)
	private Set<Publicity>  publicity;



	




}
