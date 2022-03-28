package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.History;
import tn.esprit.spring.entities.Phase;

public interface IHistoryService {
	public History addH (History his);
    public List<History> getHistorys();
    public Optional<History> finHistoryById(Long idhi);
    public void DeleteH (Long idhi);
    public History UpdateH (History his);

}
