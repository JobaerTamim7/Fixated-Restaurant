package org.example.controllers.manager;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.example.controllers.scene.SceneController;
import org.example.controllers.scene.SceneName;
import org.example.controllers.scene.SwitchSceneInterface;
import org.example.models.responses.LoginResponse;
import org.example.models.user.TempUser;
import org.example.models.user.User;
import org.example.models.user.WorkerUser;
import org.example.services.admin.AddUserService;
import org.example.services.LoginService;
import org.example.services.SignUpService;

import java.io.IOException;

public class ManagerCompleteController implements SwitchSceneInterface {

    @FXML
    private MFXTextField branchCode;

    @FXML
    private FontAwesomeIconView statusIcon;

    @FXML
    private MFXTextField mail;

    @FXML
    private MFXPasswordField password;

    @FXML
    private MFXTextField phoneNo;

    @FXML
    private MFXPasswordField repassword;

    @FXML
    private MFXTextField userName;

    @FXML
    private MFXTextField wrokerID;

    private boolean isValid = false;
    private Stage stage;

    @FXML
    void onCompleteClick(ActionEvent event) {
        String id = branchCode.getText();
        String pass = password.getText();
        String repass = repassword.getText();
        String username = userName.getText();
        String mail = this.mail.getText();
        String phoneNo = this.phoneNo.getText();
        String branchCode = this.branchCode.getText();

        boolean isMatched = pass.equals(repass);
        boolean isNull = username.isEmpty() || pass.isEmpty() || mail.isEmpty() || repass.isEmpty();

        try {
            if (!isValid){
                throw new Exception("invalid credentials");
            }
            if (!isMatched) {
                statusIcon.setIcon(FontAwesomeIcon.TIMES);
                throw new Exception("Passwords do not match");
            }
            statusIcon.setIcon(FontAwesomeIcon.CHECK);
            if (isNull){
                throw new Exception("All the fields are required");
            }

            User newUser = new WorkerUser(username,pass,"MANAGER",phoneNo,branchCode,id);
            newUser.setMail(mail);


            LoginResponse response = SignUpService.signUp(newUser);
            if (response.getStatusCode() == 201){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText(response.getMessage());
                alert.showAndWait();
                SceneController.switchScene(stage, SceneName.MANAGER_LOGIN);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText(response.getMessage());
                alert.showAndWait();
            }

        } catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
        }

    }

    @FXML
    void validationCheck(ActionEvent event) throws IOException {
        String id = wrokerID.getText();
        String username = userName.getText();
        String branch_code = branchCode.getText();

        boolean isNull = branch_code.isEmpty() || id.isEmpty() || username.isEmpty() ;
        try {
            if (isNull) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please fill up the validations field");
            }
            User user = new TempUser(username,"MANAGER",branch_code,id);

            LoginResponse loginResponse = AddUserService.validateTempUser(user);

            if (loginResponse.getStatusCode() == 200) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Validation Successful. Please fill up the rest.");
                alert.showAndWait();
                isValid = true;
            }

            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText(loginResponse.getMessage());
                alert.showAndWait();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.showAndWait();
        }

    }

    @Override
    public void initialize(Stage stage) {
        this.stage = stage;
    }
}
