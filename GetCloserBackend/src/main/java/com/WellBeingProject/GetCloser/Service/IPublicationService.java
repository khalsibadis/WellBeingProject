package com.WellBeingProject.GetCloser.Service;

import com.WellBeingProject.GetCloser.Entity.Publication;

import java.util.List;

public interface IPublicationService {
    public void AddPublication (Publication e);
    public List<Publication> getAllPublication();
    public void DeletePublication (int id);
    public void UpdatePublication (Publication e);
}
