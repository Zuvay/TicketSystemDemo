package com.javaakademi.ticketsystem.entity;

import jakarta.persistence.*;

@Entity
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String issuetitle;
    private String issuedescription;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    public Issue(int id, String issuetitle, String issuedescription, User author) {
        this.id = id;
        this.issuetitle = issuetitle;
        this.issuedescription = issuedescription;
        this.author = author;
    }

    public Issue() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIssuetitle() {
        return issuetitle;
    }

    public void setIssuetitle(String issuetitle) {
        this.issuetitle = issuetitle;
    }

    public String getIssuedescription() {
        return issuedescription;
    }

    public void setIssuedescription(String issuedescription) {
        this.issuedescription = issuedescription;
    }
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
