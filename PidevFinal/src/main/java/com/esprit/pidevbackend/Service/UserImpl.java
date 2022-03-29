package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.User;
import com.esprit.pidevbackend.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class UserImpl implements UserServiceYahia {
    @Autowired
    UserRepository UserRepo;


    @Override
    public User AddUser(User u) {
        return UserRepo.save(u);
    }

    @Override
    public User UpdateUser(User u) {
        return UserRepo.save(u);
    }

    @Override
    @Scheduled(cron = "@monthly")
    public void ResetKudos () {
        for (User u : UserRepo.findAll()) {
            u.setKudos(3);
            UserRepo.save(u);
        }

    }

    @Override
    public void DecrementKudos(Long IdUser) {

        User user = UserRepo.findById(IdUser).orElse(null);
        if (user.getKudos() > 0 && user.getKudos()<=3){
            user.setKudos(user.getKudos()-1);
            UserRepo.save(user);
        }
    }


}
