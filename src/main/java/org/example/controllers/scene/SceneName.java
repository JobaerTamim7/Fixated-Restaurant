package org.example.controllers.scene;

public enum SceneName {
    LOGIN("/view/Login.fxml"),
    SIGNUP("/view/Signup.fxml"),
    ADMIN_LOGIN("/view/AdminLogin.fxml"),
    ADMIN_PANEL("/view/AdminPanel.fxml"),
    ADMIN_SIDE_BAR("/view/Sidebar.fxml"),
    ADMIN_ADD_USER("/view/Adduser.fxml"),
    ADMIN_ALL_USERS("/view/Allusers.fxml"),
    MANAGER_LOGIN("/view/Managerlogin.fxml"),
    MANAGER_COMPLETE_PROFILE("/view/Managercomplete.fxml"),
    MENU("/view/Menu.fxml"),
    CART("/view/Cart.fxml"),;

    private final String fxmlFile;

    SceneName(String s) {
        this.fxmlFile = s;
    }
    public String getFxmlFile() {
        return fxmlFile;
    }
}
