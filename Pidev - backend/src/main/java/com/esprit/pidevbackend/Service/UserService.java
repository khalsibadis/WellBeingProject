package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.Role;
import com.esprit.pidevbackend.Domain.User;

import java.util.List;

public interface UserService {

    User saveUser(User user) ;
    Role saveRole(Role role);
    void addRoleToUser(String username , String role) ;
    User getUser(String username) ;
    Role getRole (String name);
    List<User> getUsers() ;
    List<Role> getRoles();
    void updateRole(Role role , Long id );
    User deleteUser(String username);
    Role deleteRole(String name);
    void updateUser(User user , Long id);
    void deleteRoleFromUser(String username );

}
