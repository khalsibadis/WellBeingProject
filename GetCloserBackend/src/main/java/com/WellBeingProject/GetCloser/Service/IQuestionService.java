package com.WellBeingProject.GetCloser.Service;



import com.WellBeingProject.GetCloser.Entity.Question;

import java.util.List;

public interface IQuestionService {
    public void AddQuestion (Question e);
    public List<Question> getAllQuestion();
    public void DeleteQuestion (int id);
    public void UpdateQuestion (Question e);

}
