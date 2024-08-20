package com.javaakademi.ticketsystem.repository;

import com.javaakademi.ticketsystem.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,String> {
    Users findByUsername(String username);
}
