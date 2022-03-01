package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class Level implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idl;

	private String difficulty;

	@OneToMany(mappedBy = "level", cascade = CascadeType.ALL)
	private List<Question> questions;
	
	@ManyToOne
	@JsonIgnore
	private Theme theme;
	
	public Level() {
	}

	public Level(int idl, String difficulty, List<Question> questions, Theme theme) {
		super();
		this.idl = idl;
		this.difficulty = difficulty;
		this.questions = questions;
		this.theme = theme;
	}

	public Level(String difficulty, List<Question> questions, Theme theme) {
		super();
		this.difficulty = difficulty;
		this.questions = questions;
		this.theme = theme;
	}

	public int getIdl() {
		return idl;
	}

	public void setIdl(int idl) {
		this.idl = idl;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
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