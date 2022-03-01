package tn.esprit.spring.services;

import java.util.List;



import tn.esprit.spring.entities.Theme;

public interface IThemeService {
	  

	    public void addTheme (Theme th);
	    public List<Theme> getThemes();
	    public void DeleteTh (int idt);
	    public void UpdateTh (int idt ,Theme th);
	  
}
