package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "team_id")
	    private Long id;

	    @Column(name = "team_name", unique = true, nullable = true, length = 32)
	    private String teamName;
        @JsonIgnore
	    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Game> games;
        
        public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		@JsonIgnore
	    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<User> users;

		public Team() {
			super();
		}

	

	

		public Team(Long id, String teamName) {
			super();
			this.id = id;
			this.teamName = teamName;
			this.games = games;
			this.users = users;
		}

		public String getTeamName() {
			return teamName;
		}

		public void setTeamName(String teamName) {
			this.teamName = teamName;
		}

		public List<Game> getGames() {
			return games;
		}

		public void setGames(List<Game> games) {
			this.games = games;
		}

		public List<User> getUsers() {
			return users;
		}

		public void setUsers(List<User> users) {
			this.users = users;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		 

}
