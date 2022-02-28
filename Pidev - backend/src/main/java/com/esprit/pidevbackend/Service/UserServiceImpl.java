package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.Role;
import com.esprit.pidevbackend.Domain.User;
import com.esprit.pidevbackend.Exception.UserFoundException;
import com.esprit.pidevbackend.Repository.RoleRepository;
import com.esprit.pidevbackend.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService , UserDetailsService {

    private final UserRepository userRepository ;
    private final RoleRepository roleRepository ;
    private final PasswordEncoder passwordEncoder ;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            log.error("User not found in database");
            throw  new UsernameNotFoundException("user not found in database");
        }
        else {
            log.info("User exist in the database : {} "+ username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> { authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities) ;
    }

    @Override
    public User saveUser(User user) throws UserFoundException {
        log.info("Saving new  user {} in the DB"+ user.getName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        List<User> users = userRepository.findAll();
        for (User u: users
             ) {
            if(u.getUsername().equals(user.getUsername()) ){
                throw  new UserFoundException("Username exist .. change username");
            }
            else {
                userRepository.save(user);
            }
        }
        return user ;
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new  role {} in the DB"+role.getName());
        List<Role> roles = roleRepository.findAll();
        for (Role r: roles
             ) {
            if(r.getName().equals(role.getName())){
                throw new UserFoundException("RoleName exist  .. change it ");
            }
            else {
                roleRepository.save(role);
            }

        }
        return role ;
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {} ",roleName,username);
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("fetching user {} from DB", username );
        return userRepository.findByUsername(username);
    }

    @Override
    public Role getRole(String name) {
        log.info("fetching user {} from DB", name );
        return roleRepository.findByName(name);
    }

    @Override
    public List<User> getUsers() {
        log.info("fetching all users from DB" );
        return userRepository.findAll();
    }
    @Override
    public List<Role> getRoles() {
        log.info("fetching all roles from DB" );
        return roleRepository.findAll();
    }


    @Override
    public User deleteUser(String username){
        User user = userRepository.findByUsername(username);
         userRepository.delete(user);
         return  user ;
    }

    @Override
    public Role deleteRole(String name){
        Role role = roleRepository.findByName(name);
        roleRepository.delete(role);
        return  role ;
    }

    @Override
    public void updateUser(User user , Long id){
        user.setId(id);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void updateRole(Role role , Long id){
        role.setId(id);
        roleRepository.save(role);
    }

    @Override
    public void deleteRoleFromUser(String username ){
        User user = userRepository.findByUsername(username);
        user.setRoles(null);
    }

}
