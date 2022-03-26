package com.esprit.pidevbackend.Domain;

import java.io.Serializable;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity

public class Collaboration implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long idCollaboration;
	String name;
	String description;
	int phone;
	String email;
	Date date;
	String rate ;
	String town;
	

	@OneToMany(mappedBy="collaboration", cascade=CascadeType.ALL)
	private Set<Offer> offers;
	
	@ManyToOne
	User users;

}
