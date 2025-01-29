package org.example.controllers.admin;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.controllers.scene.SceneName;
import org.example.controllers.scene.SwitchSceneInterface;

import java.io.IOException;
import java.net.ConnectException;

public class AdminPanelController implements SwitchSceneInterface {

    @FXML
    private BorderPane borderPane;

    private SidebarController sidebarController;

    private Stage stage;

    @Override
    public void initialize(Stage stage) {
        this.stage = stage;

        try {
            FXMLLoader sidebarLoader = new FXMLLoader(getClass().getResource(SceneName.ADMIN_SIDE_BAR.getFxmlFile()));
            VBox sidebar = sidebarLoader.load();
            sidebarController = sidebarLoader.getController();
            borderPane.setLeft(sidebar);
        } catch (Exception e) {
            e.printStackTrace();
        }

        setupNavigation();
        loadDefaultView();
    }

    private void setupNavigation() {
        if (sidebarController != null) {
            sidebarController.setNavConsumerFunc((fxmlFile)-> this.loadView(fxmlFile));
        } else {
            System.err.println("SidebarController is not initialized!");
        }
    }

    private void loadDefaultView() {
        loadView(SceneName.SIGNUP.getFxmlFile());
    }

    private void loadView(String fxmlPath) {
        try {
            borderPane.setCenter(CenterSceneFactory.provideCenterScene(fxmlPath));
        } catch (ConnectException e ) {
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Error");
           alert.setHeaderText("Connection error");
           alert.showAndWait();
        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.showAndWait();
        }
    }
}