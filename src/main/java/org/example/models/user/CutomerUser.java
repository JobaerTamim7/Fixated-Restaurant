package org.example.models.user;

import java.util.HashMap;
import java.util.Map;

public class CutomerUser extends User {

    private final String type = "customer";

    public CutomerUser(String user_name, String password, String role) {
        super(user_name, password, role);
    }

    @Override
    public Map<String,Object> dataToMap() {
        Map<String,Object> map = new HashMap<>();
        map.put("type", type);
        map.put("user_name",this.getUser_name());
        map.put("password",this.getPassword());
        map.put("role",this.getRole());
        map.put("mail",this.getMail());
        return map;
    }
}
