package com.kayafirat.blogkayafirat.model;


public class User {

    private String id;

    private String emailAddress;

    private String userName;

    private String userPassword;

    private String userRegisterDate;

    public User() {}

    public User(String id,String emailAddress, String userName, String userPassword,String userRegisterDate) {
        this.id = id;
        this.emailAddress = emailAddress;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRegisterDate = userRegisterDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
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
