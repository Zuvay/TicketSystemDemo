package com.javaakademi.ticketsystem.response;

public class IssueRequest {
    private int id;
    private String issuetitle;
    private String issuedescription;
    private int userid;

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

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
