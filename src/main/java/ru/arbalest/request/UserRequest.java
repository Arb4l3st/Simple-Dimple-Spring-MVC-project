package ru.arbalest.request;

public class UserRequest {

    private String fioUser;
    private String dateR;
    private String email;
    private String companyNameUser;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFioUser() {
        return fioUser;
    }

    public void setFioUser(String fioUser) {
        this.fioUser = fioUser;
    }

    public String getDateR() {
        return dateR;
    }

    public void setDateR(String dateR) {
        this.dateR = dateR;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyNameUser() {
        return companyNameUser;
    }

    public void setCompanyNameUser(String companyName) {
        this.companyNameUser = companyName;
    }
}
