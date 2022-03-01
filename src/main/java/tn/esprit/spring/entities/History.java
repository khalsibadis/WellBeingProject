package tn.esprit.spring.entities;

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
private int idh;
	
	private String username;
	
	private String themeName;

	private String levelName;
	
	private int total;
	
	private int sore;
	
	
	
	@ManyToOne
	@JsonIgnore
	private Theme theme;
	
	public History() {
	}

	

	public History(String username, String themeName, String levelName, int total, int sore, Theme theme) {
		super();
		this.username = username;
		this.themeName = themeName;
		this.levelName = levelName;
		this.total = total;
		this.sore = sore;
		this.theme = theme;
	}



	public int getIdh() {
		return idh;
	}

	public void setIdh(int idh) {
		this.idh = idh;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getThemeName() {
		return themeName;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getSore() {
		return sore;
	}

	public void setSore(int sore) {
		this.sore = sore;
	}



	public Theme getTheme() {
		return theme;
	}



	public void setTheme(Theme theme) {
		this.theme = theme;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

	
}
