package org.example;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.controllers.scene.SceneController;
import org.example.controllers.scene.SceneName;


import java.io.IOException;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException, InterruptedException {
        stage.setTitle("Fixated Kitchen");

        boolean isAdmin = System.getProperty("mode","").equals("admin");
        System.out.println(System.getProperty("mode"));

        if (isAdmin) {
            SceneController.switchScene(stage,SceneName.ADMINLOGIN);
        }
        else {
            SceneController.switchScene(stage, SceneName.LOGIN);
        }
    }
}

