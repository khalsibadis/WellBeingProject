package tn.esprit.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long IdUser  ;
	String UserName ;
	String Password ;
	String Email ;
	@OneToMany(cascade = CascadeType.ALL,mappedBy="user")
	private Set<Evaluation> Evaluations ;
	@OneToMany(cascade = CascadeType.ALL,mappedBy="UserPromotions")
	private Set<Promotion> Promotions ;
}
