package com.WellBeingProject.GetCloser.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private TypeQuestion typeQuestion;
    private String Question;
    @Enumerated(EnumType.STRING)
    private TypeAnswer typeAnswer;
    private boolean obligatory;
    @ManyToOne
    private QVT qvt;
    @OneToMany(mappedBy = "question")
    private Set<Answer>answers;


}
