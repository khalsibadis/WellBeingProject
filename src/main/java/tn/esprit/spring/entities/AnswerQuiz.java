package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class AnswerQuiz implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	private Long idA;
	private String text;

	@Column(name = "a_order")
	private Integer orderA;

	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	private Calendar createdDate;
	
	private boolean iscorrect;
	
	
	
	@ManyToOne
	@JsonIgnore
	private QuestionQuiz questionquiz;
	
	

	public AnswerQuiz() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnswerQuiz(String text, Integer orderA, Calendar createdDate, boolean iscorrect, QuestionQuiz questionquiz) {
		super();
		this.text = text;
		this.orderA = orderA;
		this.createdDate = createdDate;
		this.iscorrect = iscorrect;
		this.questionquiz = questionquiz;
	}

	public Long getIdA() {
		return idA;
	}

	public void setIdA(Long idA) {
		this.idA = idA;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getOrderA() {
		return orderA;
	}

	public void setOrderA(Integer orderA) {
		this.orderA = orderA;
	}

	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	public QuestionQuiz getQuestionquiz() {
		return questionquiz;
	}

	public void setQuestionquiz(QuestionQuiz questionquiz) {
		this.questionquiz = questionquiz;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isIscorrect() {
		return iscorrect;
	}

	public void setIscorrect(boolean iscorrect) {
		this.iscorrect = iscorrect;
	}


	

}
