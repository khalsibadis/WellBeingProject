package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class Quiz implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
    private Long idQ;
	
	private String nameTheme;
	
	private String description;
	
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = true, updatable = true)
	private Calendar createdDate;

	private Boolean isPublished = false;

	
	@OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<QuestionQuiz> questions;
    
	@OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<History> historys;
	
	@OneToOne
	@JsonIgnore
	private User createdBy;
	
	
	public Quiz() {
		
	}
	
	
	

	public Quiz(String nameTheme, String description, Calendar createdDate, Boolean isPublished,
			List<QuestionQuiz> questions, List<History> historys, User createdBy) {
		super();
		this.nameTheme = nameTheme;
		this.description = description;
		this.createdDate = createdDate;
		this.isPublished = isPublished;
		this.questions = questions;
		this.historys = historys;
		this.createdBy = createdBy;
	}




	public Long getIdQ() {
		return idQ;
	}

	public void setIdQ(Long idQ) {
		this.idQ = idQ;
	}

	public String getNameTheme() {
		return nameTheme;
	}

	public void setNameTheme(String nameTheme) {
		this.nameTheme = nameTheme;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	public Boolean getIsPublished() {
		return isPublished;
	}

	public void setIsPublished(Boolean isPublished) {
		this.isPublished = isPublished;
	}

	public List<QuestionQuiz> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionQuiz> questions) {
		this.questions = questions;
	}

	public List<History> getHistorys() {
		return historys;
	}

	public void setHistorys(List<History> historys) {
		this.historys = historys;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	


	

	
	
	
	


	

}
