module vshp.group.app {
    requires javafx.controls;
    requires javafx.fxml;


    opens vshp.group.app to javafx.fxml;
    exports vshp.group.app;
}