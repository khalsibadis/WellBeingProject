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

package com.esprit.pidevbackend.Repository;

import com.esprit.pidevbackend.Domain.Competition;
import com.esprit.pidevbackend.Domain.Room;
import com.esprit.pidevbackend.Domain.Timeslot;
import com.esprit.pidevbackend.solver.TimeTableController;
import org.optaplanner.core.api.solver.SolverStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

/**
 * This class ensures that during solving, no CRUD operations are allowed.
 */
@Component
@RepositoryEventHandler
public class ProblemChangedRepositoryEventListener {

    @Autowired
    private TimeTableController timeTableController;


    @HandleBeforeCreate
    @HandleBeforeSave
    @HandleBeforeDelete
    private void timeslotCreateSaveDelete(Timeslot timeslot) {
        assertNotSolving();
    }

    @HandleBeforeCreate
    @HandleBeforeSave
    @HandleBeforeDelete
    private void roomCreateSaveDelete(Room room) {
        assertNotSolving();
    }

    @HandleBeforeCreate
    @HandleBeforeSave
    @HandleBeforeDelete
    private void lessonCreateSaveDelete(Competition competition) {
        assertNotSolving();
    }

    public void assertNotSolving() {
        // TODO Race condition: if a timeTableSolverService.solve() call arrives concurrently,
        // the solver might start before the CRUD transaction completes. That's not very harmful, though.
        if (timeTableController.getSolverStatus() != SolverStatus.NOT_SOLVING) {
            throw new IllegalStateException("The solver is solving. Please stop solving first.");
        }
    }

}
