package com.kayafirat.blogkayafirat.model;


public class User {

    private String id;

    private String emailAddress;

    private String userName;

    private String userPassword;

    private String userRegisterDate;

    public User() {}

    public User(String emailAddress, String userName, String userPassword) {
        this.emailAddress = emailAddress;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserId() {
        return id;
    }

    public void setUserId(String id) {
        this.id = id;
    }

    public String getUserEmail() {
        return emailAddress;
    }

    public void setUserEmail(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserRegisterDate() {
        return userRegisterDate;
    }

    public void setUserRegisterDate(String userRegisterDate) {
        this.userRegisterDate = userRegisterDate;
    }
}
