package com.example.sportsscore.model;

import javax.persistence.*;

@Entity
@Table(name = "Subscribers")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public User(int id, String userName, String mail) {
        this.id = id;
        this.userName = userName;
        this.mail = mail;
    }

    public User(){

    }
    private String userName;

    private String mail;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
