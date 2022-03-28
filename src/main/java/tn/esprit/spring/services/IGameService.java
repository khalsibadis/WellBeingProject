package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import tn.esprit.spring.entities.Game;
import tn.esprit.spring.entities.Team;





public interface IGameService {
	public Game addGame (Game game);
    public List<Game> getGames();
    public Optional<Game> finGameById(Long idg);
    public void DeleteG (Long idg);
    public Game UpdateG (Game game);
    
    
    Game startGame(Team team, int numberOfQuestions, int timePerQuestion);

    void finishGame(Game game);

    Game startReview(Game game);

    void finishReview(Game game);

    void updateGame(Game game);

    Game findById(Long id);

    Long getCorrectAnswersCount(Game game);
    
   
}
