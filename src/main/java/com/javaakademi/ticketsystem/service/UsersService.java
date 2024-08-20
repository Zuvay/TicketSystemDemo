package com.javaakademi.ticketsystem.service;

import com.javaakademi.ticketsystem.entity.Users;
import com.javaakademi.ticketsystem.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UsersRepository repository;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    //Şifreyi kriptolamak
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12); //12. seviyeden bi kriptolana işlemi
    public void register(Users user){
        user.setPassword(encoder.encode(user.getPassword()));//kriptolanacak şifreyi böylece userdan kendi alacak. Security config dosyasında 52. satıra bak.
        repository.save(user);
    }

    public String verify(Users user) {
       Authentication authentication =
               authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));

        // Eğer username ve şifre eşleşmişse login yapan kişiye bir token oluştur
        // Token sayesinde erişim için her defasında username ve şifreye gerek kalmaz
       if(authentication.isAuthenticated()){
           return jwtService.generateToken(user.getUsername());
       }

       return "Failure";
    }
}
