package com.javaakademi.ticketsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "issues")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "issuetitle")
    private String issuetitle;
    @Column(name = "issuedescription")
    private String issuedescription;

    Issue() {

    }

    public Issue(int id, String username, String issuetitle, String issuedescription) {
        this.id = id;
        this.username = username;
        this.issuetitle = issuetitle;
        this.issuedescription = issuedescription;
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
}
