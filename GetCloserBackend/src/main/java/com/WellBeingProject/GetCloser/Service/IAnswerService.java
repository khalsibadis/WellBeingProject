package com.WellBeingProject.GetCloser.Service;


import com.WellBeingProject.GetCloser.Entity.Answer;

import java.util.List;

public interface IAnswerService {
    public void AddAnswer (Answer e);
    public List<Answer> getAllAnswer();
    public void DeleteAnswer (int id);
    public void UpdateAnswer (Answer e);

}
