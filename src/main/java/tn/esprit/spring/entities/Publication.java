package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Publication implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int idp;
	private int likes;
	private String tex;
	private String photo;
	
	@Temporal(TemporalType.DATE)
	private Date dateP;

	
	@OneToMany(mappedBy = "publics", cascade = CascadeType.ALL)
	private List<Comment> comment;
	
	public Publication() {
		
	}

	public Publication(int likes, String tex, String photo, Date dateP, List<Comment> comment) {
		super();
		this.likes = likes;
		this.tex = tex;
		this.photo = photo;
		this.dateP = dateP;
		this.comment = comment;
	}

	public int getIdp() {
		return idp;
	}

	public void setIdp(int idp) {
		this.idp = idp;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public String getTex() {
		return tex;
	}

	public void setTex(String tex) {
		this.tex = tex;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getDateP() {
		return dateP;
	}

	public void setDateP(Date dateP) {
		this.dateP = dateP;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	








	
	

}
