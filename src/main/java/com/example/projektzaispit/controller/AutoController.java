package com.example.projektzaispit.controller;

import com.example.projektzaispit.Program;
import com.example.projektzaispit.model.Table;
import com.example.projektzaispit.model.auto;
import com.example.projektzaispit.model.korisnik;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AutoController implements Initializable {
    @FXML
    protected void autoAdministration (ActionEvent evt){
        Stage stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        Program.swapScene(stage, "korisnik-view.fxml", "Nazad");
        System.out.println("Hello");
    }

    @FXML
    TextField modelTxt;

    @FXML
    TextField yearTxt;

    @FXML
    TableColumn tableColumnID;

    @FXML
    TableColumn tableColumnModel;

    @FXML
    TableColumn tableColumnYear;

    @FXML
    TableView tableViewAuta;

    @FXML
    Button deleteButton;

    auto selectedAuto;

    @FXML
    protected void selectAuto() {
        this.selectedAuto = (auto) this.tableViewAuta.getSelectionModel().getSelectedItem();
        this.deleteButton.setDisable(false);
        this.modelTxt.setText(this.selectedAuto.getModel());
        this.yearTxt.setText(this.selectedAuto.getYear());


    }

    @FXML
    protected void deleteAuto() throws Exception {
        if (this.selectedAuto != null) {
            this.selectedAuto.delete();
            this.fillAuta();

        }
    }

    @FXML

    protected void saveAuto () throws Exception {
        if(this.selectedAuto == null) {
            auto newAuto = new auto();
            newAuto.setModel(this.modelTxt.getText());
            newAuto.setYear(this.yearTxt.getText());
            newAuto.save();

        }else {
            this.selectedAuto.setModel(this.modelTxt.getText());
            this.selectedAuto.setYear(this.yearTxt.getText());
            this.selectedAuto.update();
            this.selectedAuto = null;
        }
        this.fillAuta();
        this.modelTxt.setText("");
        this.yearTxt.setText("");

    }
    @FXML

    private void fillAuta (){
        try {
            ObservableList<?> auta = FXCollections.observableArrayList(Table.list(auto.class));
            this.tableViewAuta.setItems(auta);
        } catch (Exception e) {
            System.out.println("Nastala je greška: " + e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tableColumnID.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.tableColumnModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        this.tableColumnYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        this.fillAuta();



    }
}
