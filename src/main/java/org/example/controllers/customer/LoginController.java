package org.example.controllers.customer;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import org.example.controllers.scene.SceneController;
import org.example.controllers.scene.SceneName;
import org.example.controllers.scene.SwitchSceneInterface;
import org.example.models.user.CutomerUser;
import org.example.models.user.User;
import org.example.utils.Utility;
import org.example.utils.AnimationFactory;
import org.example.models.animation.AnimationInfo;
import org.example.models.responses.LoginResponse;
import org.example.services.LoginService;

import java.io.IOException;

public class LoginController implements SwitchSceneInterface {

    @FXML
    private TextField userNameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label alertLabel;

    @FXML
    private AnchorPane rightSidePane;

    @FXML
    private VBox leftSideBox;

    private Stage stage;

    private SequentialTransition enterTransition;
    private SequentialTransition leaveTransition;

    private SequentialTransition createEnterTransition() {
        TranslateTransition leftTransition = AnimationFactory.createTranslateTransition(
                new AnimationInfo(leftSideBox, -leftSideBox.getWidth(), 0),
                true
        );
        TranslateTransition rightTransition = AnimationFactory.createTranslateTransition(
                new AnimationInfo(rightSidePane, -rightSidePane.getHeight(), 0),
                false
        );

        return new SequentialTransition(leftTransition, rightTransition);
    }

    private SequentialTransition createLeaveTransition() {
        TranslateTransition leftTransition = AnimationFactory.createTranslateTransition(
                new AnimationInfo(leftSideBox, 0, -leftSideBox.getWidth()),
                true
        );
        System.out.println(leftSideBox);
        TranslateTransition rightTransition = AnimationFactory.createTranslateTransition(
                new AnimationInfo(rightSidePane, 0, -rightSidePane.getHeight()),
                false
        );

        return new SequentialTransition(leftTransition, rightTransition);
    }

    @Override
    public void initialize(Stage stage) {
        this.stage = stage;

        this.enterTransition = createEnterTransition();
        this.leaveTransition = createLeaveTransition();

        Utility.animationPlay(enterTransition, leftSideBox, rightSidePane);
    }

    @FXML
    public void onClickLoginButton(Event event) throws IOException, InterruptedException {
        String userName = userNameField.getText();
        String pass = passwordField.getText();

        try {
            if (userName.isEmpty() || pass.isEmpty()) {
                throw new Exception("Mail, Password cannot be empty");
            }

            User user = new CutomerUser(userName, pass, "CUSTOMER");
            LoginResponse response = LoginService.login(user);


            if (response.getStatusCode() == 200) {
                SceneController.switchScene(this.stage, SceneName.LOGIN);
                alertLabel.setTextFill(Paint.valueOf("green"));
                alertLabel.setText(response.getMessage());
            }

            else {
                alertLabel.setTextFill(Paint.valueOf("red"));
                alertLabel.setText(response.getMessage());
            }
        }

        catch (Exception e) {
            e.printStackTrace();
            alertLabel.setTextFill(Paint.valueOf("red"));
            alertLabel.setText(e.getMessage());
        }

    }

    @FXML
    public void onClickSignUpLink(Event event) throws IOException, InterruptedException {
        Utility.animationPlay(leaveTransition, leftSideBox, rightSidePane);
        leaveTransition.setOnFinished(actionEvent ->{
            try {
                SceneController.switchScene(Utility.getStage((Node) event.getSource()), SceneName.SIGNUP);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }


}
