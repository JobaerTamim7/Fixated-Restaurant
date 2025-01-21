//package org.example.services;
//
//import java.io.IOException;
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.util.HashMap;
//import java.util.Objects;
//
//public class LogInService {
//    public static HashMap<String, Object> authenticate(String mail, String password) {
//        try {
//            String url = "http://localhost:8080/api/user/auth";
//            String payload = "{\"mail\":\"" + mail + "\",\"password\":\"" + password + "\"}";
//            HttpClient client = HttpClient.newHttpClient();
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create(url))
//                    .header("Content-Type", "application/json")
//                    .POST(HttpRequest.BodyPublishers.ofString(payload))
//                    .build();
//            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//            if (response.statusCode() == 200) {
//
//            }
//        } catch (IOException | InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//}
