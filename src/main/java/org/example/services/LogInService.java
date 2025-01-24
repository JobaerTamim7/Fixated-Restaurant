package org.example.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.models.responses.LoginResponse;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LoginService {
    public LoginResponse login(String mail, String password) throws IOException, InterruptedException {
        String url = "http://localhost:8080/api/user/auth";
        String jsonPayload = "{\"mail\":\"" + mail + "\",\"password\":\"" + password + "\"}";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
                .build();
        try {
            HttpResponse<String> serverResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = CustomObjectMapper.createCustomMapper();
            return mapper.readValue(serverResponse.body(), LoginResponse.class);
        }
        catch (ConnectException e) {
            throw new RuntimeException("Server not found");
        }


    }

}
