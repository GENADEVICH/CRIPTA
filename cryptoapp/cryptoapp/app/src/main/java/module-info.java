module vshp.group.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens vshp.group.app to javafx.fxml;
    exports vshp.group.app;
}