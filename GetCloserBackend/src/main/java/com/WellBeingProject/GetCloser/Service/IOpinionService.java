package com.WellBeingProject.GetCloser.Service;

import com.WellBeingProject.GetCloser.Entity.Opinion;

import java.util.List;

public interface IOpinionService {

    public void AddOpinion (Opinion e);
    public List<Opinion> getAllOpinions();
    public void DeleteOpinion (int id);
    public void UpdateOpinion (Opinion e);

}
