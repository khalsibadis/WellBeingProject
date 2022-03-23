package com.esprit.pidevbackend.Domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor 
@AllArgsConstructor
@ToString
@Entity
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idReservation;
    Date finDate;
    Date endDate;
    int NmPalce;

    @ManyToOne
    Offer offersRes;
    
    @ManyToOne
    User userRes;




}