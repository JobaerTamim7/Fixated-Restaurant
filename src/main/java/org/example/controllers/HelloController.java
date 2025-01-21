package org.example.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HelloController {
    @FXML
    Button helloBtn;
    @FXML
    private void hello(){
        System.out.println("Hello to javafx");
    }
}
