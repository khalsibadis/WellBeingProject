package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

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
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int idq;
	
	private String question;

	private String response1;

	private String response2;

	private String response3;

	private String correct;
	
	@ManyToOne
	@JsonIgnore
	private Level level;
	
	public Question() {
	}

	public Question(int idq, String question, String response1, String response2, String response3, String correct,
			Level level) {
		super();
		this.idq = idq;
		this.question = question;
		this.response1 = response1;
		this.response2 = response2;
		this.response3 = response3;
		this.correct = correct;
		this.level = level;
	}

	public int getIdq() {
		return idq;
	}

	public void setIdq(int idq) {
		this.idq = idq;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getResponse1() {
		return response1;
	}

	public void setResponse1(String response1) {
		this.response1 = response1;
	}

	public String getResponse2() {
		return response2;
	}

	public void setResponse2(String response2) {
		this.response2 = response2;
	}

	public String getResponse3() {
		return response3;
	}

	public void setResponse3(String response3) {
		this.response3 = response3;
	}

	public String getCorrect() {
		return correct;
	}

	public void setCorrect(String correct) {
		this.correct = correct;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	


	
	
}
