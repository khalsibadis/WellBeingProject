package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.Opinion;

import java.util.List;

public interface IOpinionService {
    public void AddOpinion(Opinion e);
    public List<Opinion> getAllOpinions();
    public void DeleteOpinion(Long id);
    public void UpdateOpinion(Opinion e);
    public void AddOpinionToUser(Opinion e, Long idUser);
    public void BlockOpinionsWithInsultingWords(Opinion e);
}
