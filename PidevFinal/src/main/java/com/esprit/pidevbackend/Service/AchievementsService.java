package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.Achievements;

import java.util.List;

public interface AchievementsService {

        public void addAchievementsandEvaluation(Long iduser);
        public Integer CalculateAndVerifyScore(Long IdUser, Integer score);
        List<Achievements> findAllOrderByScoreTotalAsc() ;

}
