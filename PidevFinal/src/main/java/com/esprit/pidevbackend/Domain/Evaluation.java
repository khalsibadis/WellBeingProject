package com.esprit.pidevbackend.Domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode
public class Evaluation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long idEvaluation ;
    Integer activitypoints ;
    Integer gamespoints ;
    Integer quizpoints ;
    Integer giftpoints ;
    @Enumerated(EnumType.STRING)
    Badge activitybadge ;
    @Enumerated(EnumType.STRING)
    Badge gamesbadge ;
    @Enumerated(EnumType.STRING)
    Badge knowledgebadge  ;
    @Temporal(TemporalType.DATE)
    Date startEvaluation ;
    @OneToOne(mappedBy="evaluation")
    private Achievements achievements ;
    public Evaluation(Integer activitypoints, Integer gamespoints, Integer quizpoints, Integer giftpoints,
                      Badge activitybadge, Badge gamesbadge, Badge knowledgebadge, Date startEvaluation) {
        super();
        this.activitypoints = activitypoints;
        this.gamespoints = gamespoints;
        this.quizpoints = quizpoints;
        this.giftpoints = giftpoints;
        this.activitybadge = activitybadge;
        this.gamesbadge = gamesbadge;
        this.knowledgebadge = knowledgebadge;
        this.startEvaluation = startEvaluation;
    }




}
