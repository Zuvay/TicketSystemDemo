package com.javaakademi.ticketsystem.repository;

import com.javaakademi.ticketsystem.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue,Long> {
    //Bu interface veritabanı işlemleri yapmamızı sağlayacak
    //save create gibi metotlar hazır olarak elimizde olacak
}
