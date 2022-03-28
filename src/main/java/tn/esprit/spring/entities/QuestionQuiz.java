package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import javax.persistence.OneToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class QuestionQuiz implements Serializable {
	    private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Long idq;
	

	    private  int point;
	 
	    @Column(name = "body", nullable = false, length = 300)
	    private String body;
	 
	    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	    private Calendar createdDate;
	 
	    @JsonIgnore
	    private Boolean isValid = false;
	 
	    @Column(name = "q_order")
		private Integer order;
	    @Column(name = "correct_answer", nullable = false, length = 100)
	    private String correctAnswer;

	    @Column(name = "hint", nullable = false, length = 200)
	    private String hint;
	    
	    @JsonIgnore
	    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Phase> phases;
	    
	    @ManyToOne
		@JsonIgnore
		private Quiz quiz;

	    @JsonIgnore
		@OneToMany(mappedBy = "questionquiz", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		private List<AnswerQuiz> answers;
		
		public QuestionQuiz() {
			
		}
		

		public QuestionQuiz(int point, String body, Calendar createdDate, Boolean isValid, Integer order,
				String correctAnswer, String hint, List<Phase> phases, Quiz quiz, List<AnswerQuiz> answers) {
			super();
			this.point = point;
			this.body = body;
			this.createdDate = createdDate;
			this.isValid = isValid;
			this.order = order;
			this.correctAnswer = correctAnswer;
			this.hint = hint;
			this.phases = phases;
			this.quiz = quiz;
			this.answers = answers;
		}


		public Long getIdq() {
			return idq;
		}

		public void setIdq(Long idq) {
			this.idq = idq;
		}

		public int getPoint() {
			return point;
		}

		public void setPoint(int point) {
			this.point = point;
		}

		public String getBody() {
			return body;
		}

		public void setBody(String body) {
			this.body = body;
		}

		public Calendar getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Calendar createdDate) {
			this.createdDate = createdDate;
		}

		public Boolean getIsValid() {
			return isValid;
		}

		public void setIsValid(Boolean isValid) {
			this.isValid = isValid;
		}

		public Integer getOrder() {
			return order;
		}

		public void setOrder(Integer order) {
			this.order = order;
		}

		public String getCorrectAnswer() {
			return correctAnswer;
		}

		public void setCorrectAnswer(String correctAnswer) {
			this.correctAnswer = correctAnswer;
		}

		public String getHint() {
			return hint;
		}

		public void setHint(String hint) {
			this.hint = hint;
		}

		public List<Phase> getPhases() {
			return phases;
		}

		public void setPhases(List<Phase> phases) {
			this.phases = phases;
		}

		public Quiz getQuiz() {
			return quiz;
		}

		public void setQuiz(Quiz quiz) {
			this.quiz = quiz;
		}

		public List<AnswerQuiz> getAnswers() {
			return answers;
		}

		public void setAnswers(List<AnswerQuiz> answers) {
			this.answers = answers;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}


		
	    
	    
	    
	    
	   
		

	

		

		
	
	
	
	
}
