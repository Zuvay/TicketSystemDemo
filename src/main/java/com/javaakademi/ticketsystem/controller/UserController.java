package com.javaakademi.ticketsystem.controller;

import com.javaakademi.ticketsystem.entity.User;
import com.javaakademi.ticketsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;


    //Giriş yapan kişinin ismini alır
    @GetMapping("/home")
    public String getUserFromAuth(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @PostMapping("/register")
    public void register(@RequestBody User user){
        service.register(user);
    }

}
