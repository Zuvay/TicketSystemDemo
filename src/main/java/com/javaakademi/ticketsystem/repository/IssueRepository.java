package com.javaakademi.ticketsystem.repository;

import com.javaakademi.ticketsystem.entity.Issue;
import com.javaakademi.ticketsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IssueRepository extends JpaRepository<Issue,String> {
    @Override
    void deleteById(String id);
    @Query("SELECT i FROM Issue i WHERE i.author.username = :username")
    List<Issue> findIssuesByAuthorUsername(@Param("username") String username);
}
