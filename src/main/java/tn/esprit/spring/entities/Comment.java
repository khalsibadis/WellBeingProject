package tn.esprit.spring.entities;

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
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int idcm; 
	private String contenu_cm;
	@Temporal(TemporalType.DATE)
	private Date date_cm;
	
	@ManyToOne
	@JsonIgnore
	private Publication publics;
	
	
	public Comment() {
		
	}
	
	public Comment(String contenu_cm, Date date_cm) {
		super();
		this.contenu_cm = contenu_cm;
		this.date_cm = date_cm;
	}

	

	public int getIdcm() {
		return idcm;
	}

	public void setIdcm(int idcm) {
		this.idcm = idcm;
	}

	public String getContenu_cm() {
		return contenu_cm;
	}

	public void setContenu_cm(String contenu_cm) {
		this.contenu_cm = contenu_cm;
	}

	public Date getDate_cm() {
		return date_cm;
	}

	public void setDate_cm(Date date_cm) {
		this.date_cm = date_cm;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
