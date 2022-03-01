package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class Theme implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
private int idT;
	
	private String nameT;
	
	@OneToMany(mappedBy = "theme", cascade = CascadeType.ALL)
	private List<Level> levels;

	@OneToMany(mappedBy = "theme", cascade = CascadeType.ALL)
	private List<History> historys;
	

	
	
	
	public Theme() {
		
	}


	


	public Theme(int idT, String nameT, List<Level> levels) {
		super();
		this.idT = idT;
		this.nameT = nameT;
		this.levels = levels;
	}





	public int getIdT() {
		return idT;
	}





	public void setIdT(int idT) {
		this.idT = idT;
	}





	public String getNameT() {
		return nameT;
	}





	public void setNameT(String nameT) {
		this.nameT = nameT;
	}





	public List<Level> getLevels() {
		return levels;
	}





	public void setLevels(List<Level> levels) {
		this.levels = levels;
	}





	public List<History> getHistorys() {
		return historys;
	}





	public void setHistorys(List<History> historys) {
		this.historys = historys;
	}





	public static long getSerialversionuid() {
		return serialVersionUID;
	}





	

}
