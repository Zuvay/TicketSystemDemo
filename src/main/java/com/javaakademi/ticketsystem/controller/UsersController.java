 package com.javaakademi.ticketsystem.controller;

import com.javaakademi.ticketsystem.entity.Users;
import com.javaakademi.ticketsystem.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService service;

    @PostMapping("/register")
    public void register(@RequestBody Users user){
        service.register(user);
    }

}
