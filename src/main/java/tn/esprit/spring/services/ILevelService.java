package tn.esprit.spring.services;

import java.util.List;



import tn.esprit.spring.entities.Level;
import tn.esprit.spring.entities.Theme;

public interface ILevelService {
	public void addL (Level lev);
    public List<Level> getLevels();
    public void DeleteL (int idl);
    public void UpdateL (Level lev);
}
