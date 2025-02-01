package org.example.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Endpoint;
import org.example.models.responses.LoginResponse;
import org.example.models.user.User;
import org.example.utils.Utility;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class LoginService {

    public static LoginResponse login(User user) throws JsonProcessingException {

        return Utility.getResponseOfPost(Endpoint.LOGIN_URL,user.dataToMap());
    }

}
