package com.javaakademi.ticketsystem.service;

import com.javaakademi.ticketsystem.entity.User;
import com.javaakademi.ticketsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    //Şifreyi kriptolamak
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12); //12. seviyeden bi kriptolana işlemi
    public void register(User user){
        user.setPassword(encoder.encode(user.getPassword()));//kriptolanacak şifreyi böylece userdan kendi alacak. Security config dosyasında 52. satıra bak.
        repository.save(user);
    }

    public User findByUsername(String username){
        return repository.findByUsername(username);
    }

}
