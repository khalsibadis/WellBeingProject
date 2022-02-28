package com.WellBeingProject.GetCloser.Service;

import com.WellBeingProject.GetCloser.Entity.Opinion;
import com.WellBeingProject.GetCloser.Repository.OpinionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpinionServiceImpl implements IOpinionService {
    @Autowired
    OpinionRepository opinionRepository;


    @Override
    public void AddOpinion(Opinion e) {
        opinionRepository.save(e);
    }

    @Override
    public List<Opinion> getAllOpinions() {
        List<Opinion> e=  opinionRepository.findAll();
        return e;
    }

    @Override
    public void DeleteOpinion(int id) {
    opinionRepository.deleteById(id);
    }

    @Override
    public void UpdateOpinion(Opinion e) {
        opinionRepository.save(e);
    }
}
