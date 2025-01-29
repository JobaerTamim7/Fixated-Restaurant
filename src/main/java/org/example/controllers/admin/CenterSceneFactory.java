package org.example.controllers.admin;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

public class CenterSceneFactory {

    public static Pane provideCenterScene(String fxmlFile) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(CenterSceneFactory.class.getResource(fxmlFile));
        Parent root = fxmlLoader.load();
        if (root instanceof Pane)
            return (Pane) root;
        else
            throw new Exception(fxmlFile + " is not a Pane");
    }
}
