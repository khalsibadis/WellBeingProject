package com.esprit.pidevbackend.Domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor

public class Achievements {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long idAchievements ;
    Integer score ;
    Integer trophee ;
    @OneToOne
    private User user ;
    @OneToOne(fetch = FetchType.LAZY)
    private Evaluation evaluation ;

    public Achievements(Integer progressionLevel, Integer score, Integer trophee) {
        super();
        this.score = score;
        this.trophee = trophee;
    }


}
