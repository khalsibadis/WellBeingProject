package com.esprit.pidevbackend.Domain;

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
	    private QuestionQuiz question;
	  

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "game_id")
	    private Game game;
}