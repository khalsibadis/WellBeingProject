package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.ConseilsUser;
import com.esprit.pidevbackend.Domain.User;

public interface IConseilsService {
    public void AddConseilToUser(Long idU);
    public ConseilsUser ConseilsPersonnalisesQuiz(Long idQvt, Long idUser);
    public ConseilsUser FindConseilByUser(Long idUser);
}
