package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUser;
	private String nomUser;
	private String prenomUser;
	private String password;
	
	public User(int idUser, String nomUser, String prenomUser, String password) {
		super();
		this.idUser = idUser;
		this.nomUser = nomUser;
		this.prenomUser = prenomUser;
		this.password = password;
	}
	public User(String nomUser, String prenomUser, String password) {
		super();
		this.nomUser = nomUser;
		this.prenomUser = prenomUser;
		this.password = password;
	}
	public User() {
		
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getNomUser() {
		return nomUser;
	}
	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}
	public String getPrenomUser() {
		return prenomUser;
	}
	public void setPrenomUser(String prenomUser) {
		this.prenomUser = prenomUser;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
