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

    @JsonProperty("user_name")
    public String getUser_name() {
        return user_name;
    }

    @JsonProperty("user_name")
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }


    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    @JsonProperty("mail")
    public String getMail() {
        return mail;
    }

    @JsonProperty("mail")
    public void setMail(String mail) {
        this.mail = mail;
    }
}
