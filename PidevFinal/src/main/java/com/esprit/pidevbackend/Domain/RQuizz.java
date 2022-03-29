package com.esprit.pidevbackend.Domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
public class RQuizz implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int PourCentageBAD;
    private int PourCentageGood;
    private int PourCentageEx;
    private String Remarque;
    @Enumerated(EnumType.STRING)
    private Note note;
    private int totalResponse;
    @OneToOne(mappedBy = "rQuizzes")
    private QVT qvt;

    public RQuizz() {
    }

    public RQuizz(int pourCentageBAD, int pourCentageGood, int pourCentageEx, String remarque, Note note, int totalResponse) {
        PourCentageBAD = pourCentageBAD;
        PourCentageGood = pourCentageGood;
        PourCentageEx = pourCentageEx;
        Remarque = remarque;
        this.note = note;
        this.totalResponse = totalResponse;
    }

    public RQuizz(Long id, int pourCentageBAD, int pourCentageGood, int pourCentageEx, String remarque, Note note, int totalResponse) {
        this.id = id;
        PourCentageBAD = pourCentageBAD;
        PourCentageGood = pourCentageGood;
        PourCentageEx = pourCentageEx;
        Remarque = remarque;
        this.note = note;
        this.totalResponse = totalResponse;
    }
}
