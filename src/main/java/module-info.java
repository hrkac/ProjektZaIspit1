module com.example.projektzaispit {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.projektzaispit to javafx.fxml;
    opens com.example.projektzaispit.model to javafx.fxml;
    exports com.example.projektzaispit;
    exports com.example.projektzaispit.controller;
    exports com.example.projektzaispit.model;
    opens com.example.projektzaispit.controller to javafx.fxml;
}