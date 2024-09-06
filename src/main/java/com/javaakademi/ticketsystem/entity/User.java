package com.javaakademi.ticketsystem.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String personalTitle;
    @OneToMany(mappedBy = "authorName") // "authorName" Issue entity'sindeki özellik
    private List<Issue> issues;
//    Sistemsel olarak doğru olan bu fakat bazı başka sorunlara sebep oluyor.
//    @OneToMany(mappedBy = "author") // "author" Issue entity'sindeki özellik
//    private List<Issue> issues1;

    public User(){}

    public User(int id, String username, String password, String personalTitle, List<Issue> issues) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.personalTitle = personalTitle;
        this.issues = issues;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPersonalTitle() {
        return personalTitle;
    }

    public void setPersonalTitle(String personalTitle) {
        this.personalTitle = personalTitle;
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }
}
