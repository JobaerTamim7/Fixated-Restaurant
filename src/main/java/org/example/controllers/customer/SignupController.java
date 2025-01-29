package org.example.controllers.customer;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.controllers.scene.SceneController;
import org.example.controllers.scene.SceneName;
import org.example.controllers.scene.SwitchSceneInterface;
import org.example.models.animation.AnimationInfo;
import org.example.models.responses.LoginResponse;
import org.example.models.user.CutomerUser;
import org.example.models.user.User;
import org.example.services.SignUpService;
import org.example.utils.AnimationFactory;
import org.example.utils.Utility;


import java.io.IOException;


public class SignupController implements SwitchSceneInterface {
    @FXML
    private MFXTextField userName;
    @FXML
    private MFXPasswordField password;
    @FXML
    private MFXTextField mail;
    @FXML
    private MFXPasswordField rePassword;


    @FXML
    private Label errorLabel;

    @FXML
    private AnchorPane leftSidePane;
    @FXML
    private AnchorPane rightSidePane;

    @FXML
    FontAwesomeIconView statusIcon;

    private Stage stage;
    private ParallelTransition leaveTransition;
    private ParallelTransition enterTransition;


    private ParallelTransition createLeaveTransition() {
        TranslateTransition leftTransition = AnimationFactory.createTranslateTransition(
                new AnimationInfo(leftSidePane,0 ,-leftSidePane.getHeight()-10),false
        );
        TranslateTransition rightTransition = AnimationFactory.createTranslateTransition(
                new AnimationInfo(rightSidePane,0,-rightSidePane.getWidth()),true
        );

        return new ParallelTransition(leftTransition, rightTransition);
    }

    private ParallelTransition createEnterTransition() {
        TranslateTransition leftTransition = AnimationFactory.createTranslateTransition(
                new AnimationInfo((Node) leftSidePane,-leftSidePane.getHeight()-10,0),false
        );
        TranslateTransition rightTransition = AnimationFactory.createTranslateTransition(
                new AnimationInfo((Node) rightSidePane,-rightSidePane.getWidth(),0),true
        );
        return new ParallelTransition(leftTransition, rightTransition);
    }


    @Override
    public void initialize(Stage stage) {
        this.stage = stage;

        Platform.runLater(() -> {
            this.enterTransition = createEnterTransition();
            this.enterTransition.setInterpolator(Interpolator.EASE_BOTH);
            this.leaveTransition = createLeaveTransition();
            this.leaveTransition.setInterpolator(Interpolator.EASE_BOTH);

            Utility.animationPlay(enterTransition,leftSidePane,rightSidePane);
        });

    }



    public void onLogInButtonClicked(Event event) throws IOException {
        Utility.animationPlay(leaveTransition,leftSidePane,rightSidePane);
        this.leaveTransition.setOnFinished(actionEvent -> {
            try {
                SceneController.switchScene(stage, SceneName.LOGIN);
            } catch (IOException e) {
                e.getCause();
            }
        });
    }

    public void onSignUpButtonClicked(Event event) throws IOException {
        String user = this.userName.getText();
        String pass = this.password.getText();
        String mail = this.mail.getText();
        String rePass = this.rePassword.getText();

        boolean isMatched = pass.equals(rePass);
        boolean isNull = user.isEmpty() || pass.isEmpty() || mail.isEmpty() || rePass.isEmpty();

        try {
            if (!isMatched) {
                statusIcon.setIcon(FontAwesomeIcon.TIMES);
                throw new Exception("Passwords do not match");
            }
            statusIcon.setIcon(FontAwesomeIcon.CHECK);
            errorLabel.setText("");
            if (isNull){
                throw new Exception("Username, password or mail cannot be empty");
            }
            User newUser = new CutomerUser(user,pass,"CUSTOMER");
            newUser.setMail(mail);

            LoginResponse response = SignUpService.signUp(newUser);
            if (response.getStatusCode() == 201){
                SceneController.switchScene(stage,SceneName.LOGIN);
            }
            else {
                errorLabel.setText(response.getMessage());
            }

        } catch (Exception e){
            errorLabel.setText(e.getMessage());
        }

    }

}
