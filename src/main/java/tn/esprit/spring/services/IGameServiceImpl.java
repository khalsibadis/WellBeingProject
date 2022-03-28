package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import tn.esprit.spring.entities.Game;
import tn.esprit.spring.entities.Phase;
import tn.esprit.spring.entities.Status;
import tn.esprit.spring.entities.Team;

import tn.esprit.spring.repository.GameRepository;
import tn.esprit.spring.repository.PhaseRepository;
import tn.esprit.spring.repository.PublicationRepository;


@Slf4j
@Service
public class IGameServiceImpl implements IGameService {
	
	@Autowired
	GameRepository gameRepository;
	
	@Autowired
	PhaseRepository phaseRepository;
	
	

	@Override
	public Game addGame(Game game) {
		return gameRepository.save(game);
	}

	@Override
	public List<Game> getGames() {
		return gameRepository.findAll();
	}

	@Override
	public Optional<Game> finGameById(Long idg) {
		return gameRepository.findById(idg);
	}

	@Override
	public void DeleteG(Long idg) {
		gameRepository.deleteById(idg);
		
	}

	@Override
	public Game UpdateG(Game game) {
	return	gameRepository.save(game);
		
	}
////////////////////////////////////////////////////////////

	@Override
	public Game startGame(Team team, int numberOfQuestions, int timePerQuestion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void finishGame(Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Game startReview(Game game) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void finishReview(Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGame(Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Game findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getCorrectAnswersCount(Game game) {
		// TODO Auto-generated method stub
		return null;
	}


}
