package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Phase;
import tn.esprit.spring.entities.Team;
import tn.esprit.spring.entities.User;

public interface ITeamService {
	
	public Team addTeam (Team team);
    public List<Team> getTeams();
    public Optional<Team> finTeamById(Long idt);
    public void DeleteTeam (Long idt);
    public Team UpdateTeam (Team team);
    
    void createTeam(String teamName);

    Team findTeamByName(String name);

    void joinTeam(User user, Long teamId);

    void leaveTeam(User user);

    void changeCaptain(User newCaptain, User oldCaptain);
}
