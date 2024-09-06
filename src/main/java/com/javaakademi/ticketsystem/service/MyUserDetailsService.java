package com.javaakademi.ticketsystem.service;

import com.javaakademi.ticketsystem.entity.UserPrincipal;
import com.javaakademi.ticketsystem.entity.User;
import com.javaakademi.ticketsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { //implementasyondan geldi
        User users = repository.findByUsername(username);

        if (users == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        //Bu metot bir UserDetails döndürmek zorunda ama bu bir interface. Buna bağlı bir class oluşturmamız lazım
        return new UserPrincipal(users);
    }
}
