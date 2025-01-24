package org.example.utils;

import javafx.animation.TranslateTransition;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Utility {
    public static void changeScene(String fxml, Scene currentScene) throws IOException {
        Stage stage = (Stage) currentScene.getWindow();

        FXMLLoader loader = new FXMLLoader(Utility.class.getResource("/fxml/" + fxml));
        Scene newScene = new Scene(loader.load());
        stage.setScene(newScene);
    }

    public static Scene getCurrentScene(Event event) {
        return ((Node) event.getSource()).getScene();
    }

    public  static TranslateTransition horizontalSliderTransition(Event event,Node node, double from, double to) {
        TranslateTransition transition = new TranslateTransition(Duration.millis(1000), node);
        transition.setFromX(from);
        transition.setToX(to);
        return transition;
    }

    public static TranslateTransition verticalSliderTransition(Node node, double from, double to) {
        TranslateTransition transition = new TranslateTransition(Duration.millis(1000), node);
        transition.setFromY(from);
        transition.setToY(to);
        return transition;
    }
    public static TranslateTransition verticalSliderTransition(Node node, double from, double to, double duration) {
        TranslateTransition transition = new TranslateTransition(Duration.millis(duration), node);
        transition.setFromY(from);
        transition.setToY(to);
        return transition;
    }
}
