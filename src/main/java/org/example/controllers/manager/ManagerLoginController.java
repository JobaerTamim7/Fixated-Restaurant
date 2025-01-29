package org.example.controllers.manager;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.controllers.scene.SceneController;
import org.example.controllers.scene.SceneName;
import org.example.controllers.scene.SwitchSceneInterface;

import java.io.IOException;

public class ManagerLoginController implements SwitchSceneInterface {

    @FXML
    private MFXTextField branchCode;

    @FXML
    private MFXButton complete;

    @FXML
    private Button loginBtn;

    @FXML
    private MFXPasswordField password;

    @FXML
    private MFXTextField phoneNo;

    @FXML
    private MFXTextField userName;

    @FXML
    private MFXTextField wrokerID;

    private Stage stage;

    @FXML
    void onClickLoginButton(ActionEvent event) {

    }

    @FXML
    void onCompleteClick(ActionEvent event) throws IOException {
        SceneController.switchScene(stage, SceneName.MANAGER_COMPLETE_PROFILE);
    }

    @Override
    public void initialize(Stage stage) {
        this.stage = stage;
    }
}
