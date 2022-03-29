package com.esprit.pidevbackend.Web;

import com.esprit.pidevbackend.Domain.Achievements;
import com.esprit.pidevbackend.Repository.IEvaluationRepository;
import com.esprit.pidevbackend.Service.AchievementsService;
import com.esprit.pidevbackend.Service.EvaluationService;
import com.esprit.pidevbackend.Service.UserServiceYahia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Evaluation")
public class EvaluationController {
    @Autowired
    UserServiceYahia userservice;
    @Autowired
    AchievementsService achieveservice;
    @Autowired
    EvaluationService evaluationservice;
    @Autowired
    IEvaluationRepository iEvaluationRepository ;


    //AchievementsController
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @PostMapping("/Add-AchievementsAndEvaluation/{IdUser}")
    @ResponseBody
    public Achievements addAchievementsandEvaluation(@PathVariable("IdUser") Long IdUser) {
        achieveservice.addAchievementsandEvaluation(IdUser);
        return null;
    }

    //Incrementation et decrementation des points
    @PostMapping("/Increment-ActivityPointsLike/{User-id}")
    public void IncrementActivityPointsLike(@PathVariable("User-id") Long IdUser) {
        evaluationservice.IncrementActivityPointsLike(IdUser);
    }

    @PostMapping("/Increment-ActivityPointsComment/{User-id}")
    public void IncrementActivityPointsComment(@PathVariable("User-id") Long IdUser) {
        evaluationservice.IncrementActivityPointsComment(IdUser);
    }
    @PostMapping("/Increment-GamesPoints/{User-id}")
    public void IncrementGamesPoints(@PathVariable("User-id") Long IdUser) {
        evaluationservice.IncrementGamesPoints(IdUser);
    }

    @PostMapping("/Decrement-ActivityPointsUnlike/{User-id}")
    public void DecrementActivityPointsUnlike(@PathVariable("User-id") Long IdUser) {
        evaluationservice.DecrementActivityPointsUnlike(IdUser);
        ;
    }

    @PostMapping("/Decrement-ActivityPointsUncomment/{User-id}")
    public void DecrementActivityPointsUncomment(@PathVariable("User-id") Long IdUser) {
        evaluationservice.DecrementActivityPointsUncomment(IdUser);
    }

    @PostMapping("/Increment-QuizPoints/{User-id}/{QuizResult}")
    public void IncrementQuizPoints(@PathVariable("User-id") Long IdUser, @PathVariable("QuizResult") Integer QuizResult) {
        evaluationservice.IncrementQuizPoints(IdUser, QuizResult);
    }

    //Reset keudos
    @PostMapping("/Resetkeudos")
    public void ResetKudos () {
        userservice.ResetKudos ();
    }

    //Affecter Les Badges
    @PostMapping("/Affect-ActivityBadge/{User-id}")
    public void AffectActivityBadge(@PathVariable("User-id") Long IdUser) {
        evaluationservice.AffectActivityBadge(IdUser);
    }
    @PostMapping("/Affect-GameBadge/{User-id}")
    public void AffectGameBadge(@PathVariable("User-id") Long IdUser) {
        evaluationservice.AffectGameBadge(IdUser);
    }
    @PostMapping("/Affect-KnowledgeBadge/{User-id}")
    public void AffectKnowledgeBadge(@PathVariable("User-id") Long IdUser) {
        evaluationservice.AffectKnowledgeBadge(IdUser);
    }


    //CalculScore
    @PostMapping("Calcul-Score/{User-id}")
    public Integer CalculateAndVerifyScore(@PathVariable("User-id") Long IdUser, Integer score) {
        return achieveservice.CalculateAndVerifyScore(IdUser,score);
    }

    //ClassementParOrdredesscores
    @GetMapping(value = "/Retrieve-Achievements")
    public List<Achievements> findAllOrderByScoreTotalAsc() {
    return achieveservice.findAllOrderByScoreTotalAsc() ;
    }
    //DecrementKeudos
    @PostMapping("/Decrement-Keudos/{User-id}")
    public void DecrementKudos(@PathVariable("User-id") Long IdUser) {
        userservice.DecrementKudos(IdUser);
    }
}