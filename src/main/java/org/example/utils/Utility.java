package org.example.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.FXPermission;
import org.example.Endpoint;
import org.example.controllers.scene.SceneName;
import org.example.models.responses.LoginResponse;
import org.example.models.user.User;
import org.example.services.CustomObjectMapper;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Utility {
//------------------------------------------------    scene section    -----------------------------------------------//
    public static Stage getStage(Node node) {
        return (Stage) node.getScene().getWindow();
    }

    public static Scene getCurrentScene(Event event) {
        return ((Node) event.getSource()).getScene();
    }

    public static Scene getCurrentScene(Node node) {
        return (Scene) node.getScene();
    }

//--------------------------------------------    animation section    -----------------------------------------------//

    public  static TranslateTransition horizontalSliderTransition(Node node, double from, double to) {
        TranslateTransition transition = new TranslateTransition(Duration.millis(1000), node);
        transition.setFromX(from);
        transition.setToX(to);
        transition.setInterpolator(Interpolator.EASE_IN);
        return transition;
    }

    public static TranslateTransition horizontalSliderTransition(Node node, double from, double to, double duration) {
        TranslateTransition transition = new TranslateTransition(Duration.millis(duration), node);
        transition.setFromX(from);
        transition.setToX(to);
        transition.setInterpolator(Interpolator.EASE_IN);
        return transition;
    }

    public static TranslateTransition verticalSliderTransition(Node node, double from, double to) {
        TranslateTransition transition = new TranslateTransition(Duration.millis(1000), node);
        transition.setFromY(from);
        transition.setToY(to);
        transition.setInterpolator(Interpolator.EASE_IN);
        return transition;
    }
    public static TranslateTransition verticalSliderTransition(Node node, double from, double to, double duration) {
        TranslateTransition transition = new TranslateTransition(Duration.millis(duration), node);
        transition.setFromY(from);
        transition.setToY(to);
        transition.setInterpolator(Interpolator.EASE_IN);
        return transition;
    }

    public static void animationPlay(ParallelTransition transition, Node... nodes) {
        transition.play();
    }

//--------------------------------------------     section    -----------------------------------------------//
    public static LoginResponse getResponseOfPost(Endpoint endpoint, Map<String,Object> payLoad) throws JsonProcessingException {
        String url =endpoint.getUrl();

        ObjectMapper mapper = CustomObjectMapper.createCustomMapper();

        String load = mapper.writeValueAsString(payLoad);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(load))
                .build();

        try {
            HttpResponse<String> rawResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
            return mapper.readValue(rawResponse.body(), LoginResponse.class);
        } catch (ConnectException e) {
            throw new RuntimeException("Server Not Found");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Something went wrong");
        }

    }
}
