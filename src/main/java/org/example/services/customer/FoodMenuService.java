package org.example.services.customer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Endpoint;
import org.example.models.food.FoodItem;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class FoodMenuService {
    public static List<FoodItem> menu(int page){
        String url = Endpoint.FOODS.getUrl() + "?page=" + page;
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            ObjectMapper objectMapper = new ObjectMapper();
            return (objectMapper.readValue(response.body(),new TypeReference<List<FoodItem>>(){}));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
