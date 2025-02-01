package org.example.controllers.scene;

public enum SceneName {
    LOGIN("/view/CustomerView/Login.fxml"),
    SIGNUP("/view/CustomerView/Signup.fxml"),
    ADMIN_LOGIN("/view/AdminView/AdminLogin.fxml"),
    ADMIN_PANEL("/view/AdminView/AdminPanel.fxml"),
    ADMIN_SIDE_BAR("/view/AdminView/Sidebar.fxml"),
    ADMIN_ADD_USER("/view/AdminView/Adduser.fxml"),
    ADMIN_ALL_USERS("/view/AdminView/Allusers.fxml"),
    MANAGER_LOGIN("/view/ManagerView/Managerlogin.fxml"),
    MANAGER_COMPLETE_PROFILE("/view/ManagerView/Managercomplete.fxml"),
    MENU("/view/CustomerView/Menu.fxml"),
    CART("/view/CustomerView/Cart.fxml"),;

    private final String fxmlFile;

    SceneName(String s) {
        this.fxmlFile = s;
    }
    public String getFxmlFile() {
        return fxmlFile;
    }
}
