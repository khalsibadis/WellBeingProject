package com.esprit.pidevbackend.Domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Game  implements Serializable {
	private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "game_id")
	    private Long idg;

	    @Column(name = "number_of_questions", nullable = false)
	    private Integer numberOfQuestions;

	    @Column(name = "time_per_question", nullable = false)
	    private Integer timePerQuestion;

	    @Column(name = "current_phase")
	    private Integer currentPhase;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "team_id")
	    private Team team;

	    @Enumerated(value = EnumType.STRING)
	    @Column(name = "status", nullable = false)
	    private Status status;

	    @OneToMany(mappedBy = "game")
	    private List<Phase> phases;

	
		public Game() {
			super();
		}

		public Long getIdg() {
			return idg;
		}

		public void setIdg(Long idg) {
			this.idg = idg;
		}

		public Integer getNumberOfQuestions() {
			return numberOfQuestions;
		}

		public void setNumberOfQuestions(Integer numberOfQuestions) {
			this.numberOfQuestions = numberOfQuestions;
		}

		public Integer getTimePerQuestion() {
			return timePerQuestion;
		}

		public void setTimePerQuestion(Integer timePerQuestion) {
			this.timePerQuestion = timePerQuestion;
		}

		public Integer getCurrentPhase() {
			return currentPhase;
		}

		public void setCurrentPhase(Integer currentPhase) {
			this.currentPhase = currentPhase;
		}

		public Team getTeam() {
			return team;
		}

		public void setTeam(Team team) {
			this.team = team;
		}

		public Status getStatus() {
			return status;
		}

		public void setStatus(Status status) {
			this.status = status;
		}

		public List<Phase> getPhases() {
			return phases;
		}

		public void setPhases(List<Phase> phases) {
			this.phases = phases;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public int hashCode() {
			return Objects.hash(currentPhase, idg, numberOfQuestions, phases, status, team, timePerQuestion);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Game other = (Game) obj;
			return Objects.equals(currentPhase, other.currentPhase) && Objects.equals(idg, other.idg)
					&& Objects.equals(numberOfQuestions, other.numberOfQuestions)
					&& Objects.equals(phases, other.phases) && status == other.status
					&& Objects.equals(team, other.team) && Objects.equals(timePerQuestion, other.timePerQuestion);
		}
	    
	    
}
