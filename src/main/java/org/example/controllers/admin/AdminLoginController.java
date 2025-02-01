package org.example.controllers.admin;

import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.controllers.scene.SceneController;
import org.example.controllers.scene.SceneName;
import org.example.controllers.scene.SwitchSceneInterface;
import org.example.models.responses.LoginResponse;
import org.example.models.user.User;
import org.example.models.user.WorkerUser;
import org.example.services.LoginService;

import java.io.IOException;


public class AdminLoginController implements SwitchSceneInterface {
    @FXML
    private MFXTextField userName;
    @FXML
    private MFXTextField password;
    @FXML
    private MFXTextField phoneNo;
    @FXML
    private MFXTextField wrokerID;
    @FXML
    private MFXTextField branchCode;

    @FXML
    private Button loginBtn;

    private Stage stage;

    @Override
    public void initialize(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void onClickLoginButton(Event event) throws IOException, InterruptedException {
        String user_name = userName.getText();
        String pass = password.getText();
        String phone = phoneNo.getText();
        String id = wrokerID.getText();
        String branch = branchCode.getText();

        boolean isEmpty = user_name.isEmpty() || pass.isEmpty() || phone.isEmpty() || id.isEmpty() || branch.isEmpty();

        try{
            if (isEmpty){
                throw new Exception("All the fields are required");
            }


            User user = new WorkerUser(user_name,pass,"ADMIN",phone,branch,id);
            LoginResponse response = LoginService.login(user);
            System.out.println(response);


            Alert alert = getAlert(response);
            alert.showAndWait();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }




    }

    private Alert getAlert(LoginResponse response) throws IOException {
        Alert alert;
        if (response.getStatusCode() == 200) {
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Login Successful");
            alert.setHeaderText("Login Successful");
            SceneController.switchScene(this.stage, SceneName.ADMIN_PANEL);
        }
        else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setContentText(response.getMessage());
        }
        return alert;
    }

}
