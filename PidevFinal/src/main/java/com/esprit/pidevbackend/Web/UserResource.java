package com.esprit.pidevbackend.Web;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.esprit.pidevbackend.Domain.Role;
import com.esprit.pidevbackend.Domain.User;

import com.esprit.pidevbackend.Repository.RoleRepository;
import com.esprit.pidevbackend.Repository.UserRepository;
import com.esprit.pidevbackend.Service.UserService;
import com.esprit.pidevbackend.email.EmailSender;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService ;
    private final UserRepository userRepository ;
    private final RoleRepository roleRepository ;
    private final EmailSender emailSender ;



    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestParam String email) {

        String response = userService.forgotPassword(email);
        String subject = "Reset your password with this Link : " ;
        if (!response.startsWith("Invalid")) {
            response = "http://localhost:8085/api/reset-password?token=" + response;
            emailSender.send(email,subject+response);

        }
        return response;
    }

    @PutMapping("/reset-password")
    public String resetPassword(@RequestParam String token,@RequestParam String newPassword) {

        return userService.resetPassword(token, newPassword);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){

        return  ResponseEntity.ok().body(userService.getUsers());
    }


    @GetMapping("/user/{username}")
    public ResponseEntity<User>  getUser(@PathVariable  String username){
        return ResponseEntity.ok().body(userService.getUser(username)) ;
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getRoles(){

        return  ResponseEntity.ok().body(userService.getRoles());
    }


    @GetMapping("/role/{name}")
    public ResponseEntity<Role>  getRole(@PathVariable String name){
        return ResponseEntity.ok().body(userService.getRole(name));
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser (@RequestParam("user") String user  , @RequestParam("f") MultipartFile f    ) throws IOException, MessagingException {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user,f ));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/addtouser/{username}/{name}")
    public ResponseEntity<?> addRoleToUser(@PathVariable String username , @PathVariable String name ){
        userService.addRoleToUser(username,name);
        return ResponseEntity.accepted().build();
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/delete-user/{username}")
    public ResponseEntity<User> deleteUser(@PathVariable  String username){
        return ResponseEntity.accepted().body(userService.deleteUser(username)) ;
    }
    @Secured("ROLE_ADMIN")
    @DeleteMapping("/delete-role/{name}")
    public ResponseEntity<Role>  deleteRole(@PathVariable String name){
        return ResponseEntity.accepted().body(userService.deleteRole(name)) ;
    }
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @PutMapping("/update-user/{id}")
    public ResponseEntity<User> updateUser(@RequestBody  User user ,@PathVariable Long id){
         userService.updateUser(user,id);
         return ResponseEntity.accepted().build();
    }
    @Secured("ROLE_ADMIN")
    @PutMapping("/update-role/{id}")
    public ResponseEntity<Role> updateRole(@RequestBody  Role role ,@PathVariable Long id ){
         userService.updateRole(role,id);
         return ResponseEntity.accepted().build();
    }
    @Secured("ROLE_ADMIN")
    @PutMapping("/delete-user-role/{username}")
    public ResponseEntity<?> deleteRoleFromUser(@PathVariable String username ){
        userService.deleteRoleFromUser(username);
        return ResponseEntity.accepted().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> ExceptionHandler(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping (path = "/images/{username}",produces = MediaType.IMAGE_JPEG_VALUE) //mediatType : sous forme image non caractere inormale
    public byte[] getImage(@PathVariable String username) throws Exception
    {
        return userService.getImage(username);
    }


    @GetMapping("/token/refresh")
    public void refreshToken (HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
                String username = decodedJWT.getSubject();
                User user = userService.getUser(username);
                String access_token = JWT.create()
                        .withSubject(user.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles",user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String , String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);
                //tokens.put("refresh_token",refresh_token);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(),tokens);


            } catch (Exception exception) {
                response.setHeader("error",exception.getMessage());
                response.setStatus(FORBIDDEN.value());
                //response.sendError(FORBIDDEN.value());
                Map<String , String> error = new HashMap<>();
                error.put("error_message", exception.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(),error);
            }
        } else {
            throw new   RuntimeException("Refresh Token is Missing") ;
        }


    }






}


