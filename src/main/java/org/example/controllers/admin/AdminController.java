package org.example.controllers.admin;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.controllers.scene.SwitchSceneInterface;
import org.example.models.responses.LoginResponse;
import org.example.models.user.User;
import org.example.models.user.WorkerUser;
import org.example.services.LoginService;

import java.io.IOException;


public class AdminController implements SwitchSceneInterface {
    @FXML
    private TextField userName;
    @FXML
    private TextField password;
    @FXML
    private TextField phoneNo;
    @FXML
    private TextField wrokerID;
    @FXML
    private TextField branchCode;

    @FXML
    private Button loginBtn;

    @Override
    public void initialize(Stage stage) {

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


            if (response.getStatusCode() == 200) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Login Successful");
                alert.setHeaderText("Login Successful");
                alert.showAndWait();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login Failed");
                alert.setContentText(response.getMessage());
                alert.showAndWait();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }




    }

}
