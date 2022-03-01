package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Level;
import tn.esprit.spring.entities.Theme;
import tn.esprit.spring.repository.HistoryRepository;
import tn.esprit.spring.repository.LevelRepository;
import tn.esprit.spring.repository.ThemeRepository;

@Slf4j
@Service
public class LevelServiceImpl implements ILevelService {
	
	@Autowired
	ThemeRepository themeRepository;
	@Autowired
	HistoryRepository historyRepository;
	@Autowired
	LevelRepository levelRepository;
	@Override
	public void addL(Level lev) {
		levelRepository.save(lev);
		
	}
	@Override
	public List<Level> getLevels() {
		
		return (List<Level>) levelRepository.findAll();
	}
	@Override
	public void DeleteL(int idl) {
		levelRepository.deleteById(idl);
		
	}
	@Override
	public void UpdateL(Level lev) {
		levelRepository.save(lev);
		
	}
	
	
	
	
	
	
}
