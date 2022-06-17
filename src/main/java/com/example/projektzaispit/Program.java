package com.example.projektzaispit;


import com.example.projektzaispit.model.*;
import com.example.projektzaispit.model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Program extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        try {
            Table.create(cijena.class);
            Table.create(auto.class);
            Table.create(korisnik.class);
            Table.create(zaposlenik.class);
            Table.create(firma.class);
            Table.create(iznajmljivanje.class);
        } catch (SQLException e) {
            System.out.println("Nastala je greška" + e.getMessage());
        }


        FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource("intro-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Rent a car!");
        stage.setScene(scene);
        stage.show();
    }

    public static void swapScene (Stage stage, String viewName, String title){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource(viewName));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle(title);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Nastala je pogreška" + e.getMessage());
        }

    }


    public static void main(String[] args) {
        launch();
    }
}
