package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.dto.ZaposleniDTO;
import com.example.demo.model.Zaposleni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bosko Gogic
 */

@RestController
@RequestMapping("/users")
public class UserController {
     
    // Autowired annotation uses for Dependency Injection; We inject our service in controller
    @Autowired
    private final UserService userService;
    
    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("/test")
    public String test() {
        System.out.println("Test is correct");
        return "User test correct";
    } 
    
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ZaposleniDTO user) {
        System.out.println("User is created");
        
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(
        value = "/login",
        consumes="application/json",
        produces=MediaType.APPLICATION_JSON_VALUE
        )
    @ResponseStatus(HttpStatus.CREATED)
    public String login(@RequestBody Zaposleni user) {
        System.out.println("Login endpoint......");
        System.out.println("User role " + user.getRole());
        if (UserService.isExist(user)) return "Login successful";
        else return "Zaposleni ne postoji";
        
    }
}
