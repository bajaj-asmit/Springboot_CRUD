package com.project.social_youtube.module;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "User3")
public class User {
    @Id()
    private Integer id;
    private String firstname;
    private String lastname;

    private String email;
    private String password;

    public User()
    {

    }
    public User(String firstname, String lastname, String email, String password,Integer id) {
        this.firstname = firstname;
        this.email = email;
        this.lastname = lastname;
        this.password = password;
        this.id=id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
