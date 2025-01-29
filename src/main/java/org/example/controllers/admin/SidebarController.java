package org.example.controllers.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.controllers.scene.SceneName;
import org.example.controllers.scene.SwitchSceneInterface;
import java.util.function.Consumer;

public class SidebarController implements SwitchSceneInterface {

    @FXML private Button dashboardBtn;
    @FXML private Button createBtn;
    @FXML private Button allUsersBtn;
    @FXML private Button reportBtn;

    private Stage stage;
    private Consumer<String> navConsumerFunc;

    public void setNavConsumerFunc(Consumer<String> onNavRequest) {
        this.navConsumerFunc = onNavRequest;
    }

    @FXML
    private void handleDashboardBtn(ActionEvent event) {
        navConsumerFunc.accept(SceneName.LOGIN.getFxmlFile());
    }

    @FXML
    private void handleCreateBtn(ActionEvent event) {
        navConsumerFunc.accept(SceneName.ADMIN_ADD_USER.getFxmlFile());
    }

    @FXML
    private void handleAllUsersBtn(ActionEvent event) {
        navConsumerFunc.accept(SceneName.ADMIN_ALL_USERS.getFxmlFile());
    }


    @Override
    public void initialize(Stage stage) {
        this.stage = stage;
    }
}