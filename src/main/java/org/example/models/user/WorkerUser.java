package org.example.models.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

import java.util.HashMap;
import java.util.Map;

public class WorkerUser extends User {

    private String phone_number;
    private String branch_code;
    private String worker_id;
    private final String type = "worker";

    @JsonCreator
    public WorkerUser(String user_name, String password, String role,
            @JsonProperty("phone_number") String phoneNumber,
            @JsonProperty("branch_code") String branchCode,
            @JsonProperty("worker_id") String workerID)
    {
        super(user_name, password, role);
        this.phone_number = phoneNumber;
        this.branch_code = branchCode;
        this.worker_id = workerID;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phone_number = phoneNumber;
    }

    public String getWorkerID() {
        return worker_id;
    }

    public void setWorkerID(String workerID) {
        this.worker_id = workerID;
    }

    public String getBranchCode() {
        return branch_code;
    }

    public void setBranchCode(String branchCode) {
        this.branch_code = branchCode;
    }

    @Override
    public Map<String,Object> dataToMap() {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("type", type);
        map.put("user_name",this.getUser_name());
        map.put("password",this.getPassword());
        map.put("role",this.getRole());
        map.put("mail",this.getMail());
        map.put("phone_number",this.phone_number);
        map.put("branch_code",this.branch_code);
        map.put("worker_id",this.worker_id);
        return map;
    }

}
