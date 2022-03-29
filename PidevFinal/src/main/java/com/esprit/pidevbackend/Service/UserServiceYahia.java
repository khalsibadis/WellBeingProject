package com.esprit.pidevbackend.Service;


import com.esprit.pidevbackend.Domain.User;

public interface UserServiceYahia {
    User AddUser(User u) ;
    User UpdateUser(User u);
    public void ResetKudos();
    public void DecrementKudos(Long IdUser);

}
