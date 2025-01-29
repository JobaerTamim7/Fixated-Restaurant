package org.example.utils;

import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.FXPermission;
import org.example.controllers.scene.SceneName;

import java.io.IOException;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class Utility {
//------------------------------------------------    scene section    -----------------------------------------------//
    public static Stage getStage(Node node) {
        return (Stage) node.getScene().getWindow();
    }

    public static Scene getCurrentScene(Event event) {
        return ((Node) event.getSource()).getScene();
    }

    public static Scene getCurrentScene(Node node) {
        return (Scene) node.getScene();
    }

//--------------------------------------------    animation section    -----------------------------------------------//

    public  static TranslateTransition horizontalSliderTransition(Node node, double from, double to) {
        TranslateTransition transition = new TranslateTransition(Duration.millis(1000), node);
        transition.setFromX(from);
        transition.setToX(to);
        transition.setInterpolator(Interpolator.EASE_IN);
        return transition;
    }

    public static TranslateTransition horizontalSliderTransition(Node node, double from, double to, double duration) {
        TranslateTransition transition = new TranslateTransition(Duration.millis(duration), node);
        transition.setFromX(from);
        transition.setToX(to);
        transition.setInterpolator(Interpolator.EASE_IN);
        return transition;
    }

    public static TranslateTransition verticalSliderTransition(Node node, double from, double to) {
        TranslateTransition transition = new TranslateTransition(Duration.millis(1000), node);
        transition.setFromY(from);
        transition.setToY(to);
        transition.setInterpolator(Interpolator.EASE_IN);
        return transition;
    }
    public static TranslateTransition verticalSliderTransition(Node node, double from, double to, double duration) {
        TranslateTransition transition = new TranslateTransition(Duration.millis(duration), node);
        transition.setFromY(from);
        transition.setToY(to);
        transition.setInterpolator(Interpolator.EASE_IN);
        return transition;
    }

    public static void animationPlay(ParallelTransition transition, Node... nodes) {
        transition.play();
    }

}
