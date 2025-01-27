package org.example.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Endpoint;
import org.example.models.responses.LoginResponse;
import org.example.models.user.User;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class SignUpService {
    public static LoginResponse signUp(User user) throws IOException,InterruptedException{
            String url = Endpoint.SIGNUP_URL.getUrl();

            Map<String, Object> payLoadMap = user.dataToMap();
            ObjectMapper mapper = CustomObjectMapper.createCustomMapper();
            String payLoad = mapper.writeValueAsString(payLoadMap);

             HttpClient client = HttpClient.newHttpClient();
             HttpRequest request = HttpRequest.newBuilder()
                     .uri(URI.create(url))
                     .header("Content-Type","application/json")
                     .POST(HttpRequest.BodyPublishers.ofString(payLoad))
                     .build();
             try {
                 HttpResponse<String> serverResponse = client.send(request,HttpResponse.BodyHandlers.ofString());
                 return  mapper.readValue(serverResponse.body(),LoginResponse.class);
             }
             catch (ConnectException e){
                throw new RuntimeException("Connection refused");
             }
    }
}
