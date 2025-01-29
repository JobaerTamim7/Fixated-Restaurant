package org.example.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.palexdev.materialfx.controls.MFXTableView;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.Endpoint;
import org.example.models.user.TableUser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ManagerTableService {

    public static void fetchData(MFXTableView<TableUser> table){
        String url = Endpoint.FETCH_MANAGERS.getUrl();
        ObservableList<TableUser> users = FXCollections.observableArrayList();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenAccept(response->{
                        System.out.println(response);
                        ObjectMapper mapper = new ObjectMapper();
                        try {
                            List<TableUser> userList = mapper.readValue(response,
                                    mapper.getTypeFactory().constructCollectionType(List.class, TableUser.class));
                            System.out.println(userList.size());
                            Platform.runLater(()->{
                               table.getItems().setAll(userList);
                            });
                        } catch (JsonProcessingException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .exceptionally(ex -> {
                System.err.println("HTTP request failed: " + ex.getMessage());
                ex.printStackTrace();
                return null;
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
