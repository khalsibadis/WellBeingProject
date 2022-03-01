package tn.esprit.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode

public class Promotion {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long idPromotion ;
	String categoriePromotion ;
	Integer pourcentagePromotion ;
	@ManyToOne
	User UserPromotions ;
}
