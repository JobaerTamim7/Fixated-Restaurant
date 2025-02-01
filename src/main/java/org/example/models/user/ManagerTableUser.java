package org.example.models.user;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ManagerTableUser{

    private int id;
    private String name;
    private String mail;
    private String role;
    private String phone_number;
    private String worker_id;
    private String branch_code;


    @JsonCreator
    public ManagerTableUser(@JsonProperty("name") String user_name,
                            @JsonProperty("mail") String mail,
                            @JsonProperty("role") String role,
                            @JsonProperty("phone_number") String phone_number,
                            @JsonProperty("worker_id") String worker_id,
                            @JsonProperty("branch_code") String branch_code) {
        this.name = user_name;
        this.mail = mail;
        this.role = role;
        this.phone_number = phone_number;
        this.worker_id = worker_id;
        this.branch_code = branch_code;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getRole() {
        return role;
    }

    public String getWorker_id() {
        return worker_id;
    }

    public String getBranch_code() {
        return branch_code;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setWorker_id(String worker_id) {
        this.worker_id = worker_id;
    }

    public void setBranch_code(String branch_code) {
        this.branch_code = branch_code;
    }
}
