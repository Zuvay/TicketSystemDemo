package com.javaakademi.ticketsystem.response;

import com.javaakademi.ticketsystem.entity.Issue;

public class IssueResponse {
    private int id;
    private String issuetitle;
    private String issuedescription;
    private String authorName;
    private String authorTitle;

    public IssueResponse(Issue issue) {
        this.id= issue.getId();
        this.issuetitle = issue.getIssuetitle();
        this.issuedescription = issue.getIssuedescription();
        this.authorName=issue.getAuthor().getUsername();
        this.authorTitle=issue.getAuthor().getPersonalTitle();
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
