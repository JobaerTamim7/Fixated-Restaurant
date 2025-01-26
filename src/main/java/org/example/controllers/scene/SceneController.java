package org.example.controllers.scene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {

    public static void switchScene(Stage stage, SceneName toSceneName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SceneController.class.getResource(toSceneName.getFxmlFile()));
        Scene scene = new Scene(fxmlLoader.load());
        SwitchSceneInterface controller = fxmlLoader.getController();
        stage.setScene(scene);
        controller.initialize(stage);
        stage.show();
    }
}
