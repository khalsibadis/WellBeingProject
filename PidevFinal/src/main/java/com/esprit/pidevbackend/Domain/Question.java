package com.esprit.pidevbackend.Domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TypeQuestion typeQuestion;
    private String Question;
    @ManyToOne
    private QVT qvt;
    @OneToMany(mappedBy = "question")
    private Set<Answer>answers;


}
