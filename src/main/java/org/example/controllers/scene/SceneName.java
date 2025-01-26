package org.example.controllers.scene;

public enum SceneName {
    LOGIN("/view/Login.fxml"),
    SIGNUP("/view/Signup.fxml"),
    ADMINLOGIN("/view/AdminLogin.fxml");

    private final String fxmlFile;

    SceneName(String s) {
        this.fxmlFile = s;
    }
    public String getFxmlFile() {
        return fxmlFile;
    }
}
