package tn.esprit.spring.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Team;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.TeamRepository;

@Slf4j
@Service
@Transactional
public class ITeamServiceImpl implements ITeamService {
	@Autowired
	TeamRepository teamRepository;

	@Override
	public Team addTeam(Team team) {
		
		return teamRepository.save(team);
	}

	@Override
	public List<Team> getTeams() {
		
		return teamRepository.findAll();
	}

	@Override
	public Optional<Team> finTeamById(Long idt) {
	
		return teamRepository.findById(idt);
	}

	@Override
	public void DeleteTeam(Long idt) {
		teamRepository.deleteById(idt);
		
	}

	@Override
	public Team UpdateTeam(Team team) {
		return teamRepository.save(team);
		
	}
	/////////////////////

	@Override
	public void createTeam(String teamName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Team findTeamByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void joinTeam(User user, Long teamId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leaveTeam(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeCaptain(User newCaptain, User oldCaptain) {
		// TODO Auto-generated method stub
		
	}

	
}
