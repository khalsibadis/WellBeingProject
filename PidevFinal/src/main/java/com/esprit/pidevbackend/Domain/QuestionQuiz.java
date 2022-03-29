package com.esprit.pidevbackend.Domain;

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

	    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Phase> phases;
	    
	    @ManyToOne
		@JsonIgnore
		private Quiz quiz;

		//@JsonIgnore
		@OneToMany(mappedBy = "questionquiz", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		private List<AnswerQuiz> answers;
	    
	    
	    
	    
	    
	    
	   
		

	

		

		
	
	
	
	
}
