package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.History;
import tn.esprit.spring.repository.HistoryRepository;
import tn.esprit.spring.repository.QuizRepository;

@Slf4j
@Service
public class HistoryServiceImpl implements IHistoryService {
	
	@Autowired
	HistoryRepository historyRepository;
	
	

	@Override
	public History addH(History his) {
		return historyRepository.save(his);
	}

	@Override
	public List<History> getHistorys() { 
	
		return historyRepository.findAll();
	}
	
	@Override
	public Optional<History> finHistoryById(Long idhi) {
	
		return historyRepository.findById(idhi);
	}
	

	@Override
	public void DeleteH(Long idhi) {
		historyRepository.deleteById(idhi);
	}

	@Override
	public History UpdateH(History his) {
		
		return historyRepository.save(his);
	}

	
	
	

	

}
