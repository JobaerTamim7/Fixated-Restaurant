package org.example.controllers.admin;

import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.example.controllers.scene.SwitchSceneInterface;
import org.example.models.responses.LoginResponse;
import org.example.models.user.TempUser;
import org.example.models.user.User;
import org.example.models.user.UserMap;
import org.example.services.AddUserService;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class AddUserController implements SwitchSceneInterface {

    private Stage stage;

    @FXML
    private MFXTextField branchCode;

    @FXML
    private MFXTextField id;

    @FXML
    private MFXTextField userName;

    private String getYear(){
        Instant instant = Instant.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy").withZone(ZoneId.of("UTC"));
        return formatter.format(instant);
    }

    @Override
    public void initialize(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void generateID(ActionEvent event) {
        try {
            if (branchCode.getText().isEmpty()) {
                throw new Exception("Need to fill branch id first");
            }
            id.setText(getYear() + "-" + UserMap.MANAGER.getValue() + "-" + branchCode.getText());
        }catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }

    }

    @FXML
    public void generateUserName(ActionEvent event) {
        try {
            if (branchCode.getText().isEmpty()) {
                throw new Exception("Need to fill branch id first");
            }
            userName.setText(UserMap.MANAGER.getName() + "-" + branchCode.getText());
        }catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    public void onAddClicked(Event event) throws Exception {
        String userName = this.userName.getText();
        String branchCode = this.branchCode.getText();
        String workerID = this.id.getText();

        boolean isNull = userName.isEmpty() || branchCode.isEmpty() || workerID.isEmpty();
        try {

            if (isNull) {
                throw new Exception("All fields must be filled up");
            }

            User user = new TempUser(userName, "MANAGER", branchCode, workerID);

            LoginResponse response = AddUserService.addTempUser(user);
            Alert alert = getAlert(response);
            alert.showAndWait();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    private static Alert getAlert(LoginResponse response) {
        Alert alert;
        if (response.getStatusCode() == 201) {
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("User added successfully");
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(response.getMessage());
        }
        return alert;
    }


}
