package com.esprit.pidevbackend.Domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class QVT implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Date date;
    private int nbrQuestion;
    @OneToMany(mappedBy = "qvt")
    private Set<Question> questions;
    @OneToOne
    private RQuizz rQuizzes;
}
