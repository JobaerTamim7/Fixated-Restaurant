module fooddelivery {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.net.http;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires com.fasterxml.jackson.databind;

    exports org.example to javafx.graphics;
    exports org.example.models.responses to com.fasterxml.jackson.databind;

    opens org.example.controllers to javafx.fxml;
    opens org.example.models.animation to javafx.fxml;
    exports org.example.utils to javafx.graphics;
    opens org.example.utils to javafx.fxml;

}