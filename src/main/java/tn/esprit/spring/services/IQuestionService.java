package tn.esprit.spring.services;

import java.util.List;



import tn.esprit.spring.entities.History;
import tn.esprit.spring.entities.Level;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.entities.Question;
import tn.esprit.spring.entities.Theme;


public interface IQuestionService {
	
	public void addQuestion (Question qt);
    public List<Question> getQuestions();
    public void DeleteQt (int idq);
    public void UpdateTh (Question qt);
	


}
