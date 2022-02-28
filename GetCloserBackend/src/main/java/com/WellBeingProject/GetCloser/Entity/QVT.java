package com.WellBeingProject.GetCloser.Entity;

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
    private int id;
    private String description;
    private boolean notification;
    private Date date;
    private int nbrQuestion;
    @ManyToOne
    private Account account;
    @OneToMany(mappedBy = "qvt")
    private Set<Question> questions;

}
