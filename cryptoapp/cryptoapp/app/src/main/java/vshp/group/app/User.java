package vshp.group.app;

public class User {
    private String Name;
    private String surName;
    private String patronymicName;
    private String ageUser;
    private String phoneUser;
    private String emailUser;
    private String loginUser;
    private String passwordUser;

    public User(String name, String surName, String patronymicName, String ageUser, String phoneUser, String emailUser, String loginUser, String passwordUser) {
        Name = name;
        this.surName = surName;
        this.patronymicName = patronymicName;
        this.ageUser = ageUser;
        this.phoneUser = phoneUser;
        this.emailUser = emailUser;
        this.loginUser = loginUser;
        this.passwordUser = passwordUser;
    }

    public User() {

    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public void setPatronymicName(String patronymicName) {
        this.patronymicName = patronymicName;
    }

    public String getAgeUser() {
        return ageUser;
    }

    public void setAgeUser(String ageUser) {
        this.ageUser = ageUser;
    }

    public String getPhoneUser() {
        return phoneUser;
    }

    public void setPhoneUser(String phoneUser) {
        this.phoneUser = phoneUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }
}
