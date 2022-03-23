package com.esprit.pidevbackend.Controller;

import com.esprit.pidevbackend.ServiceImp.IPublicityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class publicitycontroller {
    @Autowired
    IPublicityService publicityService;
}
