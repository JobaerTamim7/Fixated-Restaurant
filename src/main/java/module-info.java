module fooddelivery {

    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;


    requires de.jensd.fx.glyphs.fontawesome;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires com.fasterxml.jackson.annotation;
    requires MaterialFX;


    requires java.net.http;


    opens org.example to javafx.fxml, com.fasterxml.jackson.databind;
    opens org.example.controllers.admin to javafx.fxml;
    opens org.example.controllers.manager to javafx.fxml;
    opens org.example.controllers.customer to javafx.fxml;
    opens org.example.models.animation to javafx.fxml;
    opens org.example.models.responses to com.fasterxml.jackson.databind;
    opens org.example.utils to javafx.fxml;
    opens org.example.controllers.scene to javafx.fxml;
    opens org.example.models.user to com.fasterxml.jackson.databind;


    exports org.example to javafx.graphics;
    exports org.example.models.responses to com.fasterxml.jackson.databind;
    exports org.example.utils;
    exports org.example.models.animation;
    exports org.example.controllers.scene;
    exports org.example.models.user;
}