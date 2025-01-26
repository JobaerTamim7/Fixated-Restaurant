package org.example.models.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

public abstract class User {
    private String user_name;
    private String password;
    private String role;
    private String mail;

    public User(String user_name, String password, String role) {
        this.user_name = user_name;
        this.password = password;
        this.role = role;
    }

    public abstract Map<String, Object> dataToMap();

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
