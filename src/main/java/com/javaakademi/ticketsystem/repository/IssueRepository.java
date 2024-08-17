package com.javaakademi.ticketsystem.repository;

import com.javaakademi.ticketsystem.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IssueRepository extends JpaRepository<Issue,String> {
    @Override
    void deleteById(String id);
    //Bu interface veritabanı işlemleri yapmamızı sağlayacak
    //save create gibi metotlar hazır olarak elimizde olacak
}
