package com.javaakademi.ticketsystem.controller;

import com.javaakademi.ticketsystem.entity.Users;
import com.javaakademi.ticketsystem.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService service;


    //Giriş yapan kişinin ismini alır
    @GetMapping("/home")
    public String getUserFromAuth(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @PostMapping("/register")
    public void register(@RequestBody Users user){
        service.register(user);
    }

}
