package tn.esprit.spring.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import tn.esprit.spring.entities.Game;
import tn.esprit.spring.entities.Phase;
import tn.esprit.spring.entities.Quiz;
import tn.esprit.spring.repository.HistoryRepository;
import tn.esprit.spring.repository.PhaseRepository;
import tn.esprit.spring.repository.QuestionRepository;
import tn.esprit.spring.repository.QuizRepository;




@Slf4j
@Service
public class PhaseServiceImpl implements IPhaseService {
	

	@Autowired
     QuestionRepository questionRepository;
	
	

	@Autowired
	PhaseRepository phaseRepository;

	@Override
	public Phase addPhase(Phase phase) {
		
		return phaseRepository.save(phase);
	}

	@Override
	public List<Phase> getphases() {
		return phaseRepository.findAll();
	}

	@Override
	public Optional<Phase> finPhaseById(Long idph) {
		
		return  phaseRepository.findById(idph);
	}

	@Override
	public void DeletePh(Long idph) {
		
		 phaseRepository.deleteById(idph);
	}

	@Override
	public Phase UpdatePh(Phase phase) {
		return phaseRepository.save(phase);
		
	}
////////////////////////////////////////

	@Override
	public void generatePhaseList(Game game, Integer numberOfPhases) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initiatePhase(Phase phase, Integer timePerQuestion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Phase> findPhasesByGameId(Long gameId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void finishPhase(Phase phase, String givenAnswer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reviewPhasePositively(Phase phase) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void useHint(Phase phase) {
		// TODO Auto-generated method stub
		
	}
	
	
}
