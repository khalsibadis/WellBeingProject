package tn.esprit.spring.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Phase implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Long idPh;
	    @Column(name = "hint_used")
	    private Boolean hintUsed;

	    @Column(name = "is_correct")
	    private Boolean isCorrect;

	    @Column(name = "start_time")
	    private LocalDateTime startTime;

	    @Column(name = "end_time")
	    private LocalDateTime endTime;

	    @Column(name = "deadline")
	    private LocalDateTime deadline;

	    @Column(name = "given_answer")
	    private String givenAnswer;

	   
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "question_id", nullable = false)
	    @JsonIgnore
	    private QuestionQuiz question;
	  

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "game_id")
	    @JsonIgnore
	    private Game game;
          
	   

		public Phase(Boolean hintUsed, Boolean isCorrect, LocalDateTime startTime, LocalDateTime endTime,
				LocalDateTime deadline, String givenAnswer, QuestionQuiz question, Game game) {
			super();
			this.hintUsed = hintUsed;
			this.isCorrect = isCorrect;
			this.startTime = startTime;
			this.endTime = endTime;
			this.deadline = deadline;
			this.givenAnswer = givenAnswer;
			this.question = question;
			this.game = game;
		}
     


		public Phase() {
			super();
			// TODO Auto-generated constructor stub
		}



		public Long getIdPh() {
			return idPh;
		}



		public void setIdPh(Long idPh) {
			this.idPh = idPh;
		}



		public Boolean getHintUsed() {
			return hintUsed;
		}



		public void setHintUsed(Boolean hintUsed) {
			this.hintUsed = hintUsed;
		}



		public Boolean getIsCorrect() {
			return isCorrect;
		}



		public void setIsCorrect(Boolean isCorrect) {
			this.isCorrect = isCorrect;
		}



		public LocalDateTime getStartTime() {
			return startTime;
		}



		public void setStartTime(LocalDateTime startTime) {
			this.startTime = startTime;
		}



		public LocalDateTime getEndTime() {
			return endTime;
		}



		public void setEndTime(LocalDateTime endTime) {
			this.endTime = endTime;
		}



		public LocalDateTime getDeadline() {
			return deadline;
		}



		public void setDeadline(LocalDateTime deadline) {
			this.deadline = deadline;
		}



		public String getGivenAnswer() {
			return givenAnswer;
		}



		public void setGivenAnswer(String givenAnswer) {
			this.givenAnswer = givenAnswer;
		}



		public QuestionQuiz getQuestion() {
			return question;
		}



		public void setQuestion(QuestionQuiz question) {
			this.question = question;
		}



		public Game getGame() {
			return game;
		}



		public void setGame(Game game) {
			this.game = game;
		}



		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	    
	    
	    
}