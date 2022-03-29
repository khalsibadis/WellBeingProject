package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.Role;
import com.esprit.pidevbackend.Domain.User;
import com.esprit.pidevbackend.Exception.UserFoundException;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface UserService {

    User saveUser(String user , MultipartFile file ) throws IOException, MessagingException ;
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
    byte[] getImage(String  username) throws IOException ;
    String forgotPassword(String email);
    String resetPassword(String token, String password);








}
