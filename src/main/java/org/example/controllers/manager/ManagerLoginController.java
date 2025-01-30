package org.example.controllers.manager;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import org.example.controllers.scene.SceneController;
import org.example.controllers.scene.SceneName;
import org.example.controllers.scene.SwitchSceneInterface;
import org.example.models.responses.LoginResponse;
import org.example.models.user.CutomerUser;
import org.example.models.user.User;
import org.example.models.user.WorkerUser;
import org.example.services.LoginService;

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
        String username =  userName.getText();
        String pass = password.getText();
        String phone = phoneNo.getText();
        String wroker = wrokerID.getText();
        String branch = branchCode.getText();

        boolean isNull = username.isEmpty() || pass.isEmpty() || phone.isEmpty() || wroker.isEmpty() || branch.isEmpty();

        try {
            if (isNull) {
                throw new Exception("All fields are required");
            }

            User user = new WorkerUser(username, pass, "MANAGER", phone, branch, wroker);
            LoginResponse response = LoginService.login(user);


            if (response.getStatusCode() == 200) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Login Successful");
                alert.showAndWait();
            }

            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText(response.getMessage());
                alert.showAndWait();
            }
        }

        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
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
