package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lombok.extern.slf4j.Slf4j;

import tn.esprit.spring.entities.Theme;
import tn.esprit.spring.repository.HistoryRepository;
import tn.esprit.spring.repository.QuestionRepository;
import tn.esprit.spring.repository.ThemeRepository;

@Slf4j
@Service
public class ThemeServiceImpl implements IThemeService {
	
	@Autowired
	ThemeRepository themeRepository;
	
	
	
	@Override
	public void addTheme(Theme th) {
		themeRepository.save(th);
		
	}
	@Override
	public List<Theme> getThemes() {
		return (List<Theme>) themeRepository.findAll();
	}
	@Override
	public void DeleteTh(int idt) {
		themeRepository.deleteById(idt);
		
	}
	@Override
	public void UpdateTh(int idt, Theme th) {
		  
		        th = themeRepository.findById(idt).orElse(null);
		        themeRepository.save(th);
		    }
		
	
	
	
	
	
	


}
