package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.QVT;

import java.util.List;

public interface IQVTService {

    public void AddQVT(QVT e);
    public List<QVT> getAllQVT();
    public void DeleteQVT(Long id);
    public void UpdateQVT(QVT e);
    public void ConseilsPersonnalisesQuiz(Long idQuizz);
}
