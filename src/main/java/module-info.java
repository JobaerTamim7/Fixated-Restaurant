module fooddelivery {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.net.http;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires com.fasterxml.jackson.databind;
    requires java.desktop;

    exports org.example to javafx.graphics;
    exports org.example.models.responses to com.fasterxml.jackson.databind;
    exports org.example.utils;
    exports org.example.models.animation;


    opens org.example.controllers to javafx.fxml;
    opens org.example.models.animation to javafx.fxml;
    opens org.example.utils to javafx.fxml;
    opens org.example.controllers.scene to javafx.fxml;

}