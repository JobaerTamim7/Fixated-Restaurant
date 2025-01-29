package org.example.models.user;


import java.util.HashMap;
import java.util.Map;

public class TempUser extends WorkerUser{

    private final String type = "temp_user";

    public TempUser(String user_name, String role, String branchCode, String workerID) {
        super(user_name, null, role, null, branchCode, workerID);
    }

    @Override
    public Map<String,Object> dataToMap() {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("type", type);
        map.put("user_name",this.getUser_name());
        map.put("role",this.getRole());
        map.put("branch_code",this.getBranchCode());
        map.put("worker_id",this.getWorkerID());
        return map;
    }
}
