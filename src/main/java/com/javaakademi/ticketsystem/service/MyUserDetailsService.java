package com.javaakademi.ticketsystem.service;

import com.javaakademi.ticketsystem.entity.UserPrincipal;
import com.javaakademi.ticketsystem.entity.Users;
import com.javaakademi.ticketsystem.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UsersRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { //implementasyondan geldi
        Users users = repository.findByUsername(username);

        if (users == null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }

        //Bu metot bir UserDetails döndürmek zorunda ama bu bir interface. Buna bağlı bir class oluşturmamız lazım


        return new UserPrincipal(users);
    }
}
