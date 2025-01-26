package org.example.controllers;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.controllers.scene.SceneController;
import org.example.controllers.scene.SceneName;
import org.example.controllers.scene.SwitchSceneInterface;
import org.example.models.animation.AnimationInfo;
import org.example.utils.AnimationFactory;
import org.example.utils.Utility;

import java.awt.*;
import java.io.IOException;

public class SignupController implements SwitchSceneInterface {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private TextField mail;
    @FXML
    private PasswordField rePassword;

    @FXML
    private Button signUpButton;

    @FXML
    private Hyperlink loginLink;
    @FXML
    private AnchorPane leftSidePane;
    @FXML
    private AnchorPane rightSidePane;

    private Stage stage;
    private SequentialTransition leaveTransition;
    private SequentialTransition enterTransition;


    private SequentialTransition createLeaveTransition() {
        TranslateTransition leftTransition = AnimationFactory.createTranslateTransition(
                new AnimationInfo(leftSidePane,0 ,-leftSidePane.getHeight()),false
        );
        TranslateTransition rightTransition = AnimationFactory.createTranslateTransition(
                new AnimationInfo(rightSidePane,0,-rightSidePane.getWidth()),true
        );

        return new SequentialTransition(leftTransition, rightTransition);
    }

    private SequentialTransition createEnterTransition() {
        TranslateTransition leftTransition = AnimationFactory.createTranslateTransition(
                new AnimationInfo((Node) leftSidePane,-leftSidePane.getHeight(),0),false
        );
        TranslateTransition rightTransition = AnimationFactory.createTranslateTransition(
                new AnimationInfo((Node) rightSidePane,-rightSidePane.getWidth(),0),true
        );
        return new SequentialTransition(leftTransition, rightTransition);
    }


    @Override
    public void initialize(Stage stage) {
        this.stage = stage;

        this.enterTransition = createEnterTransition();
        this.leaveTransition = createLeaveTransition();

        Utility.animationPlay(enterTransition,leftSidePane,rightSidePane);
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

;

    }

}
