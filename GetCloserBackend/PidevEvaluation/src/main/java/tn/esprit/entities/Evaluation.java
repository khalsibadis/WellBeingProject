package tn.esprit.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

public class Evaluation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long idEvaluation ;
	Integer pointsReactivite ;
	Integer pointsJeux ;
	Integer pointsCadeaux ;
	@Enumerated(EnumType.STRING)
	Badge badgeUser ;
	@Temporal(TemporalType.DATE)
	Date periodeEvaluation ;
	@ManyToOne
	User user ;

}
