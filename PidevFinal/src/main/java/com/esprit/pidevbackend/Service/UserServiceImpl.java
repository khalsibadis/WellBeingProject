package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.Role;
import com.esprit.pidevbackend.Domain.User;

import com.esprit.pidevbackend.Exception.UserFoundException;
import com.esprit.pidevbackend.Feign.PictureRestClient;
import com.esprit.pidevbackend.Repository.RoleRepository;
import com.esprit.pidevbackend.Repository.UserRepository;


import com.esprit.pidevbackend.Twilio.Smsrequest;
import com.esprit.pidevbackend.Twilio.Smsservice;
import com.esprit.pidevbackend.email.EmailSender;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.transaction.Transactional;
import javax.validation.constraints.Email;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService , UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailSender emailSender;
    private final PictureRestClient pictureRestClient;
    private final Smsservice smsservice ;
    private final MailService mailService ;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            log.error("User not found in database");
            throw new UsernameNotFoundException("user not found in database");
        } else {
            log.info("User exist in the database : {} " + username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }


    @Override
    @Transactional
    public User saveUser(String user, MultipartFile file) throws UserFoundException, IOException, MessagingException {
        User newUser = new ObjectMapper().readValue(user, User.class);
        String FileName = pictureRestClient.uploadFile(file);
        //String FileName = uploadFile(file);
        log.info("Saving new  user {} in the DB" + newUser.getName());
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        List<User> users = userRepository.findAll();
        for (User u : users
        ) {
            if (u.getUsername().equals(newUser.getUsername())) {
                throw new UserFoundException("Username exist .. change username");
            } else {


            }
        }newUser.setPicture(FileName);
        userRepository.save(newUser);
        String subject = "Welcome to Our APP";
        //emailSender.send(newUser.getEmail(),subject);
        mailService.sendEmail(newUser.getEmail());
        Smsrequest s = new Smsrequest(newUser.getPhoneNumber(),"Dear "+newUser.getName()+" Welcome to Well Being Application") ;
        smsservice.sendsms( s );
        Role role1 = roleRepository.findByName("ROLE_USER");
        newUser.getRoles().add(role1);
        return newUser;
    }

    @Override
    @Transactional
    public Role saveRole(Role role) {
        log.info("Saving new  role {} in the DB" + role.getName());
        List<Role> roles = roleRepository.findAll();
        for (Role r : roles
        ) {
            if (r.getName().equals(role.getName())) {
                throw new UserFoundException("RoleName exist  .. change it ");
            } else {

            }

        }roleRepository.save(role);
        return role;
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {} ", roleName, username);
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override

    public User getUser(String username) {
        log.info("fetching user {} from DB", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public Role getRole(String name) {
        log.info("fetching user {} from DB", name);
        return roleRepository.findByName(name);
    }

    @Override
    public List<User> getUsers() {
        log.info("fetching all users from DB");
        return userRepository.findAll();
    }

    @Override
    public List<Role> getRoles() {
        log.info("fetching all roles from DB");
        return roleRepository.findAll();
    }


    @Override
    public User deleteUser(String username) {
        User user = userRepository.findByUsername(username);
        userRepository.delete(user);
        return user;
    }

    @Override
    public Role deleteRole(String name) {
        Role role = roleRepository.findByName(name);
        roleRepository.delete(role);
        return role;
    }

    @Override
    public void updateUser(User user, Long id) {
        user.setId(id);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void updateRole(Role role, Long id) {
        role.setId(id);
        roleRepository.save(role);
    }

    @Override
    public void deleteRoleFromUser(String username) {
        User user = userRepository.findByUsername(username);
        user.setRoles(null);
    }


    @Override
    public byte[] getImage(String username) throws IOException {
        String imageName = userRepository.findByUsername(username).getPicture();
        File f = new File(System.getProperty("user.home") + "/images/" + imageName);
        Path p = Paths.get(f + "");
        return Files.readAllBytes(p);
    }
/*
    private String uploadFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename(); // elyes.jpeg -->elyes_1234.jpeg
        String tab[] = fileName.split("\\."); //elyes|jpeg
        String modifiedName = tab[0] + System.currentTimeMillis() + "." + tab[1]; // tab[0] = elyes , tab[1]=jpeg
        File f = new File(System.getProperty("user.home") + "/images/" + modifiedName);
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(file.getBytes());
        return modifiedName;
    }  */


    private static final long EXPIRE_TOKEN_AFTER_MINUTES = 300;

    public String forgotPassword(String email) {

        Optional<User> userOptional = Optional.ofNullable(userRepository.findByEmail(email));

        if (!userOptional.isPresent()) {
            return "Invalid email id.";
        }

        User user = userOptional.get();
        user.setToken(generateToken());
        user.setTokenCreationDate(LocalDateTime.now());

        user = userRepository.save(user);

        return user.getToken();
    }

    public String resetPassword(String token, String newPassword) {

        Optional<User> userOptional = Optional
                .ofNullable(userRepository.findByToken(token));

        if (!userOptional.isPresent()) {
            return "Invalid token.";
        }

        LocalDateTime tokenCreationDate = userOptional.get().getTokenCreationDate();

        if (isTokenExpired(tokenCreationDate)) {
            return "Token expired.";

        }

        User user = userOptional.get();

        user.setPassword(passwordEncoder.encode(newPassword));
        user.setToken(null);
        user.setTokenCreationDate(null);

        userRepository.save(user);

        return "Your password successfully updated.";
    }


    private String generateToken() {
        StringBuilder token = new StringBuilder();

        return token.append(UUID.randomUUID().toString())
                .append(UUID.randomUUID().toString()).toString();
    }


    private boolean isTokenExpired(final LocalDateTime tokenCreationDate) {

        LocalDateTime now = LocalDateTime.now();
        Duration diff = Duration.between(tokenCreationDate, now);

        return diff.toMinutes() >= EXPIRE_TOKEN_AFTER_MINUTES;
    }

}









