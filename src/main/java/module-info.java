module fooddelivery {
    // javafx modules
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    // third party
    requires de.jensd.fx.glyphs.fontawesome;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;


    // core java
    requires java.net.http;
    requires java.desktop;

    //
    opens org.example to javafx.fxml, com.fasterxml.jackson.databind;
    opens org.example.controllers.admin to javafx.fxml;
    opens org.example.controllers.customer to javafx.fxml;
    opens org.example.models.animation to javafx.fxml;
    opens org.example.models.responses to com.fasterxml.jackson.databind;
    opens org.example.utils to javafx.fxml;
    opens org.example.controllers.scene to javafx.fxml;


    exports org.example to javafx.graphics;
    exports org.example.models.responses to com.fasterxml.jackson.databind;
    exports org.example.utils;
    exports org.example.models.animation;
}