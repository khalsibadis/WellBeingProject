package com.esprit.pidevbackend.Controller;

import com.esprit.pidevbackend.Domain.Collaboration;
import com.esprit.pidevbackend.Domain.User;
import com.esprit.pidevbackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    UserService userService;

    //http://localhost:8085/addUser
    @PostMapping("/addUser")
    @ResponseBody
    public void addCollaboration(@RequestBody User u)
    {
        userService.saveUser(u);
    }
}
