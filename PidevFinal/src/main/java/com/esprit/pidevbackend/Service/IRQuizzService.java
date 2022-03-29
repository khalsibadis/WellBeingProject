package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.RQuizz;

import java.util.List;

public interface IRQuizzService {
    public void AddRQuizz(RQuizz e);
    public List<RQuizz> getAllRQuizz();
    public void DeleteRQuizz(Long id);
    public void UpdateRQuizz(RQuizz e);
    public void AddRQuizzToQuizz(RQuizz e, Long idQuizz);
    public RQuizz SelectRquizz(Long id);
}
