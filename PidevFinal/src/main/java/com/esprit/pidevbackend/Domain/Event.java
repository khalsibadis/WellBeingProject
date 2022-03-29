package com.esprit.pidevbackend.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Transactional
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer nbrPlace;
    private Integer nbrParticipate;
    private String place;
    private Date date;
    private Date finalDateRquest;
    private boolean recommondation;
    @Enumerated(EnumType.STRING)
    private IneterestCenter ineterestCenter;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<User> users;
    @JsonIgnore
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Commentaire> commentaires;


}

