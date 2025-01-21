package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));

        // Create a Scene with the root node
        Scene scene = new Scene(loader.load());

        // Set up the Stage
        stage.setTitle("JavaFX with FXML"); // Set the window title
        stage.setScene(scene); // Set the scene to the stage
        stage.show(); // Display the stage
    }
}