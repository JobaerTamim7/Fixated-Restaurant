package org.example.models.user;


import com.fasterxml.jackson.annotation.JsonProperty;

public class TableUser {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("mail")
    private String mail;

    @JsonProperty("role")
    private String role;

    @JsonProperty("phone_number")
    private String phone_number;

    @JsonProperty("worker_id")
    private String worker_id;

    @JsonProperty("branch_code")
    private String branch_code;

    public TableUser() {}

    public TableUser(String user_name, String mail, String role, String phone_number, String workerID,String branch_code) {
        this.name = user_name;
        this.mail = mail;
        this.role = role;
        this.phone_number = phone_number;
        this.worker_id = workerID;
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
