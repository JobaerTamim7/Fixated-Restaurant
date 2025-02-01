package org.example.services.admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.Endpoint;
import org.example.models.responses.LoginResponse;
import org.example.models.user.User;
import org.example.utils.Utility;

public class AddUserService {
    public static LoginResponse addTempUser(User user) throws JsonProcessingException {
        return Utility.getResponseOfPost(Endpoint.ADD_USER,user.dataToMap());
    }

    public static LoginResponse validateTempUser(User user) throws JsonProcessingException {
        return Utility.getResponseOfPost(Endpoint.VALIDATE_MANAGER,user.dataToMap());
    }
}
