package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.History;
import tn.esprit.spring.repository.HistoryRepository;
import tn.esprit.spring.repository.ThemeRepository;

@Slf4j
@Service
public class HistoryServiceImpl implements IHistoryService {
	
	@Autowired
	HistoryRepository historyRepository;
	
	
	
	@Override
	public void addH(History his) {
		historyRepository.save(his);
		
	}

	@Override
	public List<History> getHistorys() {
		return (List<History>) historyRepository.findAll();
	}

	@Override
	public void DeleteH(int idh) {
		historyRepository.deleteById(idh);
		
	}

	@Override
	public void UpdateH(History his) {
		historyRepository.save(his);
		
	}
	

}
