package org.example;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
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
        boolean isManager = System.getProperty("mode","").equals("manager");

        if (isAdmin) {
            SceneController.switchScene(stage,SceneName.ADMIN_LOGIN);
        }
        else if (isManager) {
            SceneController.switchScene(stage,SceneName.MANAGER_LOGIN);
        }
        else {
            SceneController.switchScene(stage, SceneName.LOGIN);
        }
    }
}

