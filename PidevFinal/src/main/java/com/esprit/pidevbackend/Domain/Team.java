package com.esprit.pidevbackend.Domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "team_id")
	    private Long id;

	    @Column(name = "team_name", unique = true, nullable = false, length = 32)
	    private String teamName;

	    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Game> games;

	    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<User> users;

		public Team() {
			super();
		}

}
