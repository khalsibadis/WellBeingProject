package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;


import tn.esprit.spring.entities.Game;
import tn.esprit.spring.entities.Phase;
import tn.esprit.spring.entities.Quiz;


public interface IPhaseService {
	public Phase addPhase (Phase phase);
    public List<Phase> getphases();
    public Optional<Phase> finPhaseById(Long idph);
    public void DeletePh (Long idph);
    public Phase UpdatePh (Phase phase);
    
    void generatePhaseList(Game game, Integer numberOfPhases);

    void initiatePhase(Phase phase, Integer timePerQuestion);

    List<Phase> findPhasesByGameId(Long gameId);

    void finishPhase(Phase phase, String givenAnswer);

    void reviewPhasePositively(Phase phase);

    void useHint(Phase phase);
   
    
  
    
    

}
