package com.javaakademi.ticketsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "issues")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String issuetitle;
    private String issuedescription;
    private String authorName;
    private String authorTitle;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    public Issue(int id, String issuetitle, String issuedescription, String authorName, String authorTitle, User author) {
        this.id = id;
        this.issuetitle = issuetitle;
        this.issuedescription = issuedescription;
        this.authorName = authorName;
        this.authorTitle = authorTitle;
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorTitle() {
        return authorTitle;
    }

    public void setAuthorTitle(String authorTitle) {
        this.authorTitle = authorTitle;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
