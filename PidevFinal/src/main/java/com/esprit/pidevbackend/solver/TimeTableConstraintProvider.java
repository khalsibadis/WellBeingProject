/*
 * Copyright 2020 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.esprit.pidevbackend.solver;

import com.esprit.pidevbackend.Domain.Competition;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import org.optaplanner.core.api.score.stream.Joiners;

import java.time.Duration;

public class TimeTableConstraintProvider implements ConstraintProvider {

    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[] {
                // Hard constraints
                roomConflict(constraintFactory),
                refereeConflict(constraintFactory),
                teamConflict(constraintFactory),
                // Soft constraints
                refereeRoomStability(constraintFactory),
                refereeTimeEfficiency(constraintFactory),
                teamSubjectVariety(constraintFactory)
        };
    }

    private Constraint roomConflict(ConstraintFactory constraintFactory) {
        // A room can accommodate at most one Competition at the same time.
        return constraintFactory
                // Select each pair of 2 different Competition ...
                .fromUniquePair(Competition.class,
                        // ... in the same timeslot ...
                        Joiners.equal(Competition::getTimeslot),
                        // ... in the same room ...
                        Joiners.equal(Competition::getRoom))
                // ... and penalize each pair with a hard weight.
                .penalize("Room conflict", HardSoftScore.ONE_HARD);
    }

    private Constraint refereeConflict(ConstraintFactory constraintFactory) {
        // A Referee can judge at most one Competition at the same time.
        return constraintFactory
                .fromUniquePair(Competition.class,
                        Joiners.equal(Competition::getTimeslot),
                        Joiners.equal(Competition::getReferee))
                .penalize("Refree conflict", HardSoftScore.ONE_HARD);
    }

    private Constraint teamConflict(ConstraintFactory constraintFactory) {
        // A team can attend at most one Competition at the same time.
        return constraintFactory
                .fromUniquePair(Competition.class,
                        Joiners.equal(Competition::getTimeslot),
                        Joiners.equal(Competition::getTeam))
                .penalize("Competition group conflict", HardSoftScore.ONE_HARD);
    }

    private Constraint refereeRoomStability(ConstraintFactory constraintFactory) {
        // A referee prefers to judge in a single room.
        return constraintFactory
                .fromUniquePair(Competition.class,
                        Joiners.equal(Competition::getReferee))
                .filter((lesson1, lesson2) -> lesson1.getRoom() != lesson2.getRoom())
                .penalize("Referee room stability", HardSoftScore.ONE_SOFT);
    }

    private Constraint refereeTimeEfficiency(ConstraintFactory constraintFactory) {
        // A Referee prefers to judge sequential competition and dislikes gaps between competition .
        return constraintFactory
                .from(Competition.class)
                .join(Competition.class, Joiners.equal(Competition::getReferee),
                        Joiners.equal((lesson) -> lesson.getTimeslot().getDayOfWeek()))
                .filter((lesson1, lesson2) -> {
                    Duration between = Duration.between(lesson1.getTimeslot().getEndTime(),
                            lesson2.getTimeslot().getStartTime());
                    return !between.isNegative() && between.compareTo(Duration.ofMinutes(30)) <= 0;
                })
                .reward("Referee time efficiency", HardSoftScore.ONE_SOFT);
    }

    private Constraint teamSubjectVariety(ConstraintFactory constraintFactory) {
        // A team group dislikes sequential competition on the same subject.
        return constraintFactory
                .from(Competition.class)
                .join(Competition.class,
                        Joiners.equal(Competition::getSubject),
                        Joiners.equal(Competition::getTeam),
                        Joiners.equal((lesson) -> lesson.getTimeslot().getDayOfWeek()))
                .filter((lesson1, lesson2) -> {
                    Duration between = Duration.between(lesson1.getTimeslot().getEndTime(),
                            lesson2.getTimeslot().getStartTime());
                    return !between.isNegative() && between.compareTo(Duration.ofMinutes(30)) <= 0;
                })
                .penalize("team group subject variety", HardSoftScore.ONE_SOFT);
    }

}
