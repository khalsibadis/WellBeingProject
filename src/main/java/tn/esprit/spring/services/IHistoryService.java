package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.History;
import tn.esprit.spring.entities.Level;

public interface IHistoryService {
	public void addH (History his);
    public List<History> getHistorys();
    public void DeleteH (int idh);
    public void UpdateH (History his);

}
