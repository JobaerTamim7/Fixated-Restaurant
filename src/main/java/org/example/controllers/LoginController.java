package org.example.controllers;

import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.example.utils.Utility;
import org.example.utils.AnimationFactory;
import org.example.models.animation.AnimationInfo;
import org.example.models.responses.LoginResponse;
import org.example.services.LoginService;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField userNameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Hyperlink forgotPassLink;

    @FXML
    private Button loginButton;

    @FXML
    private Label alertLabel;

    @FXML
    private Hyperlink signUpLink;

    @FXML
    private AnchorPane rightSidePane;

    @FXML
    private VBox leftSideBox;



    @FXML
    public void onClickLoginButton(Event event) throws IOException, InterruptedException {
        String userName = userNameField.getText();
        String pass = passwordField.getText();
        try {
            if (userName.isEmpty() || pass.isEmpty()) {
                throw new Exception("Mail or Password cannot be empty");
            }
            LoginService loginService = new LoginService();
            LoginResponse response = loginService.login(userName, pass);
            if (response.getStatusCode() == 200) {
                Utility.changeScene("Signup.fxml", Utility.getCurrentScene(event));
            }
            alertLabel.setText(response.getMessage());
        } catch (Exception e) {
            alertLabel.setText(e.getMessage());
        } finally {
            userNameField.clear();
            passwordField.clear();
        }
    }

    @FXML
    public void onClickSignUpLink(Event event) throws IOException, InterruptedException {
        TranslateTransition transition1 = AnimationFactory.runAnimation(
                new AnimationInfo((Node) rightSidePane,rightSidePane.getTranslateY() , Utility.getCurrentScene(event).getHeight())
                );
        TranslateTransition transition =  Utility.horizontalSliderTransition(event,(Node) leftSideBox, 0,Utility.getCurrentScene(event).getWidth());
        SequentialTransition sequentialTransition = new SequentialTransition(transition1, transition);
        sequentialTransition.play();

//        Utility.changeScene("Signup.fxml", Utility.getCurrentScene(event));
    }
}
