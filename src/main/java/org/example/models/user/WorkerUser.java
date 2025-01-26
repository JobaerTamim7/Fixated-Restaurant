package org.example.models.user;

import java.util.HashMap;
import java.util.Map;

public class WorkerUser extends User {

    private String phoneNumber;
    private String branchCode;
    private String workerID;
    private final String type = "worker";

    public WorkerUser(String user_name, String password, String role, String phoneNumber, String branchCode, String workerID) {
        super(user_name, password, role);
        this.phoneNumber = phoneNumber;
        this.branchCode = branchCode;
        this.workerID = workerID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWorkerID() {
        return workerID;
    }

    public void setWorkerID(String workerID) {
        this.workerID = workerID;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    @Override
    public Map<String,Object> dataToMap() {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("type", type);
        map.put("user_name",this.getUser_name());
        map.put("password",this.getPassword());
        map.put("role",this.getRole());
        map.put("mail",this.getMail());
        map.put("phone_no",this.phoneNumber);
        map.put("branch_code",this.branchCode);
        map.put("worker_id",this.workerID);
        return map;
    }

}
